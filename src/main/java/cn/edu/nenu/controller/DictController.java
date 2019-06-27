package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Dict;
import cn.edu.nenu.service.DictService;
import cn.edu.nenu.util.Constants;
import cn.edu.nenu.util.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * DictController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-09 22:39
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    private static final int PAGE_SIZE = 15;

    @Autowired
    private DictService dictService;


    @RequestMapping("")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request){

        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<Dict> dicts = dictService.getEntityPage(searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("dicts", dicts);
        model.addAttribute("sortType", sortType);
        model.addAttribute("PAGE_SIZE", PAGE_SIZE);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "setting/dictList";
    }

    @GetMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("dict", new Dict());
        model.addAttribute("action", "create");
        return "setting/dictForm";
    }

    @PostMapping(value = "create")
    public String create(@Valid Dict newDict, RedirectAttributes redirectAttributes) {
        float sort = dictService.getMaxSort();
        newDict.setSort(sort+1);
        newDict.setStatus(Constants.Status.ENABLE);
        dictService.save(newDict);
        redirectAttributes.addFlashAttribute("message", "创建数据字典成功");
        return "redirect:/dict/";
    }

    @GetMapping(value = "update/{id}")
    public String updateForm(@PathVariable("id") Long pkId, Model model){
        Dict dict =  dictService.findOne(pkId);
        model.addAttribute("dict",dict);
        model.addAttribute("action", "update");
        return "setting/dictForm";
    }

    @PostMapping(value = "update")
    public String update(@Valid Dict dict, RedirectAttributes redirectAttributes){
        Long pkId = dict.getId();
        Dict newDict = dictService.findOne(pkId);
        newDict.setType(dict.getType());
        newDict.setCode(dict.getCode());
        newDict.setName(dict.getName());

        dictService.save(newDict);
        redirectAttributes.addFlashAttribute("message", "更改数据字典信息成功");
        return "redirect:/dict/";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long pkId, RedirectAttributes redirectAttributes) {
        String message = "删除字典成功";
        try {
            dictService.remove(pkId);
        }catch (Exception e){
            message = "删除字典失败，该字典被使用";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/dict/";
    }

    @PostMapping(value = "delete")
    public String deleteBatch(ServletRequest request,RedirectAttributes redirectAttributes){
        String[] chkIds = request.getParameterValues("chkIds");
        for (String id:chkIds){
            dictService.remove(Long.valueOf(id));
        }
        return "redirect:/dict/";
    }

}
