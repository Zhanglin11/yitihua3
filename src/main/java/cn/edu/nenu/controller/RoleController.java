package cn.edu.nenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RoleController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 0:55
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("")
    public String list(){
        return "rbac/roleList";
    }
}
