package com.web.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Tag;
import com.web.blog.dto.BlogDetail;
import com.web.blog.dto.BlogIndexShow;
import com.web.blog.service.BlogService;
import com.web.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/24 19:41
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/tags/{id}")
    public String tags(@PathVariable(value = "id") Long id, Model model,
                       @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "update_time desc";
        ArrayList<Tag> tags = new ArrayList<>();
        List<Tag> listTags = tagService.listTags();
        if (id == -1) {
            id = listTags.get(0).getId();
        }
        for (Tag tag : listTags) {
            tag.setBlogs(blogService.listBlogByTagId(tag.getId()));
            tags.add(tag);
        }
        PageHelper.startPage(pageNum,5,orderBy);
        PageInfo<BlogDetail> pageInfo = new PageInfo<>(tagService.getBlogDetail(id));
        model.addAttribute("tags",tags);
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("activeTypeId",id);
        return "tags";
    }
}
