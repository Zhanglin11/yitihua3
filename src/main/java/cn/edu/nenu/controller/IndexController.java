package cn.edu.nenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;

/**
 * IndexController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-07 22:44
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("name", "oxidyc");
        System.out.println("indexController.class");
        return "index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createForm(Model model) {
        String message = "进入界面";
        model.addAttribute("message", message);

        return new ModelAndView ("user/createForm").addObject("message",message);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(ServletRequest request, RedirectAttributes redirectAttributes) {
        //保存用户信息
        redirectAttributes.addFlashAttribute("message", "创建成功");
        return "redirect:/index/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String pkId, Model model) {
        model.addAttribute("id", pkId);
        return "user/updateForm";
    }
}
