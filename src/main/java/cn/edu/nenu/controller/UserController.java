package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Dict;
import cn.edu.nenu.domain.User;
import cn.edu.nenu.service.DictService;
import cn.edu.nenu.service.UserService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * UserController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-15 7:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final int PAGE_SIZE = 15;

    @Autowired
    public UserService userService;
    @Autowired
    public DictService dictService;

    @RequestMapping("")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request){
        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<User> users = userService.getEntityPage(searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("users", users);
        model.addAttribute("sortType", sortType);
        model.addAttribute("PAGE_SIZE", PAGE_SIZE);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "rbac/userList";
    }

    //@RequestMapping(value = "/create",method = RequestMethod.GET)
    @GetMapping(value = "/create")
    public String createForm(Model model){
        List<Dict> genders = dictService.findByType("GB_GENDER");
        model.addAttribute("genders", genders);
        return "rbac/userForm";
    }

    //@RequestMapping(value = "/create",method = RequestMethod.POST)
    @PostMapping(value = "/create")
    public String create(RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("message", "创建用户");
        return "redirect:/user";
    }

    @GetMapping(value = "/update/{id}")
    public String updateForm(@PathVariable("id") Long id,Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "rbac/updateForm";
    }

    @PostMapping(value = "/update")
    public String update(){
        return "";
    }

    @PostMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, HttpServletRequest request){
        String[] ids = request.getParameterValues("ids");
        return "redirect:/user";
    }
}
