package cn.edu.nenu.controller;

import cn.edu.nenu.service.AccountService;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-15 7:55
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public AccountService accountService;

    @GetMapping()
    public String login() {
        return "login";
    }

    @PostMapping()
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "login";
    }

    //@GetMapping(value = "")
    //public String loginFrom(){
    //    return "login";
    //}
    //
    //@PostMapping(value = "")
    ////@RequestMapping(value = "",method = RequestMethod.POST)
    //public String login(Model model, ServletRequest request){
    //    String username = request.getParameter("username");
    //    String password = request.getParameter("password");
    //    User user = accountService.login(username,password);
    //    System.out.println("username:"+username+"; password:"+password);
    //    if (user==null){
    //        model.addAttribute("message","用户登录失败");
    //        return "login";
    //    }else{
    //        model.addAttribute("user",user);
    //        return "loginSuccess";
    //    }


    //}
}
