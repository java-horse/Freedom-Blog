package com.web.blog.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mabin
 * @date 2020/3/14 14:43
 */
@Controller
@RequestMapping("/admin")
public class UtilsController {

    @Value("${swaggerURL}")
    private String swaggerURL;

    @GetMapping(value = "/swagger")
    public String toSeaggerUI (Model model) {
        System.out.println(swaggerURL);
        model.addAttribute("swaggerURL",swaggerURL);
        return "admin/swagger";
    }

}
