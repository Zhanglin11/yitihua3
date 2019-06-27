package cn.edu.nenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CategoryController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 0:55
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @RequestMapping("")
    public String list(){
        return "article/categoryList";
    }
}
