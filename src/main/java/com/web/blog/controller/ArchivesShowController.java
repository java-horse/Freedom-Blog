package com.web.blog.controller;

import com.web.blog.dto.BlogShow;
import com.web.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author mabin
 * @date 2020/2/25 12:30
 */
@Controller
public class ArchivesShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/archives")
    private String archives(Model model) {
        Map<String, List<BlogShow>> map = blogService.archivesBlogs();
        model.addAttribute("blogMap",map);
        model.addAttribute("blogCount",blogService.blogCount());
        return "archives";
    }
}
