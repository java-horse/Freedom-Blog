package com.web.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

/**
 * @author mabin
 * @date 2020/2/25 15:01
 */
@Controller
public class AboutShowController {

    private String avatar = "https://i.picsum.photos/id/" + (new Random().nextInt(64) + 800) + "/" + 800 + "/" + 573 + ".jpg";

    @GetMapping(value = "/about")
    public String about(Model model) {
        /*设置随机图片*/
        model.addAttribute("image", avatar);
        return "about";
    }
}
