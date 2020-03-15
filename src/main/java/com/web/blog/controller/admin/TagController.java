package com.web.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Tag;
import com.web.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/18 17:38
 */
@Controller
@RequestMapping(value = "/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/tags")
    public String tags(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 8,orderBy);
        List<Tag> adminTags = tagService.listTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(adminTags);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    /*---------------新增--------------------*/

    @GetMapping(value = "/tags/input")
    public String addTagsPage() {
        return "admin/tags-input";
    }

    @PostMapping(value = "/tags")
    public String addTagsName(RedirectAttributes redirectAttributes, Tag tag) {
        Tag tagsByName = tagService.getTagsByName(tag.getName());
        if (tagsByName == null) {
            int saveTags = tagService.saveTags(tag);
            if (saveTags > 0) {
                redirectAttributes.addFlashAttribute("message", "新增成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "新增失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "标签名称已存在");
            return "redirect:/admin/tags/input";
        }
        return "redirect:/admin/tags";
    }

    /*------------------编辑-----------------------*/

    @GetMapping(value = "/tags/{id}")
    public String updateTagsPage(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("tag", tagService.getTagsById(id));
        return "admin/tags-update";
    }

    @PutMapping(value = "/tags")
    public String updateTagsName(Tag tag, RedirectAttributes redirectAttributes) {
        Tag tagsByName = tagService.getTagsByName(tag.getName());
        if (tagsByName == null) {
            int updateTags = tagService.updateTags(tag);
            if (updateTags > 0) {
                redirectAttributes.addFlashAttribute("message", "更新成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "更新失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "标签名称已存在");
            /*注意：这里重定向到tags-input页面，因为那个页面不用传值*/
            return "redirect:/admin/tags/input";
        }
        return "redirect:/admin/tags";
    }

    /*-----------------删除------------------*/

    @DeleteMapping(value = "/tags/{id}")
    public String deleteTagPage(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        tagService.deleteTags(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }

}
