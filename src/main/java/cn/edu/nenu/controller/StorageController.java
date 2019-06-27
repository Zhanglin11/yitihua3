package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Storage;
import cn.edu.nenu.service.StorageService;
import cn.edu.nenu.util.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * StorageController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 0:56
 */
@Controller
@RequestMapping("/storage")
public class StorageController {

    private static final int PAGE_SIZE = 15;

    @Autowired
    public StorageService storageService;

    @RequestMapping("")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request){

        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<Storage> storages = storageService.getEntityPage(searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("storages", storages);
        model.addAttribute("sortType", sortType);
        model.addAttribute("PAGE_SIZE", PAGE_SIZE);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "setting/storageList";
    }

    @GetMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("storage", new Storage());
        model.addAttribute("action", "create");
        return "setting/storageForm";
    }

    @PostMapping(value = "create")
    public String create(@Valid Storage newStorage, RedirectAttributes redirectAttributes) {
        float sort = storageService.getMaxSort();
        newStorage.setSort(sort+1);
        storageService.save(newStorage);
        redirectAttributes.addFlashAttribute("message", "创建储存路径成功");
        return "redirect:/storage/";
    }
}
