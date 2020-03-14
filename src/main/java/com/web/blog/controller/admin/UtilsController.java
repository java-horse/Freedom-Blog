package com.web.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mabin
 * @date 2020/3/14 14:43
 */
@Controller
@RequestMapping("/admin")
public class UtilsController {

    /**
     * 跳转swagger-ui API页面
     * @return
     */
    @GetMapping(value = "/swagger")
    public String toSeaggerUI () {
        return "redirect:/swagger-ui.html";
    }

}
