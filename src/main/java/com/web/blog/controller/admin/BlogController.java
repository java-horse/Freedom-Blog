package com.web.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Blog;
import com.web.blog.bean.User;
import com.web.blog.dto.BlogQuery;
import com.web.blog.dto.BlogSearch;
import com.web.blog.dto.BlogShow;
import com.web.blog.service.BlogService;
import com.web.blog.service.TagService;
import com.web.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/19 14:46
 */
@Controller
@RequestMapping(value = "/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;


    /**
     * 跳转blog页面并陈列显示
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/blogs")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<BlogQuery> blogQueries = blogService.listBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueries);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", typeService.getAdminType());
        model.addAttribute("tags", tagService.listTags());
        return "admin/blogs";
    }

    /*-------------------新增---------------------*/

    @GetMapping(value = "/blogs/input")
    public String addBlogPage(Model model) {
        model.addAttribute("types", typeService.getAdminType());
        model.addAttribute("tags", tagService.listTags());
        return "admin/blogs-input";
    }

    @PostMapping(value = "/blogs/input")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes, HttpSession session) {
        Blog addBlogById = blogService.getBlogById(blog.getId());
        if (addBlogById == null) {
            //设置用户信息:User
            blog.setUser((User) session.getAttribute("loginUser"));
            blog.setUserId(blog.getUser().getId());
            //设置分类信息:Type
            blog.setType(typeService.getTypeById(blog.getType().getId()));
            blog.setTypeId(blog.getType().getId());
            //设置标签信息:List<Tags>
            blog.setTags(tagService.getTagsString(blog.getTagIds()));
            int saveBlogCount = blogService.saveBlog(blog);
            if (saveBlogCount > 0) {
                redirectAttributes.addFlashAttribute("message", "发布成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "发布失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "博客已存在");
            return "redirect:/admin/blogs/input";
        }
        return "redirect:/admin/blogs";
    }

    /*-------------------编辑---------------------*/

    @GetMapping(value = "/blogs/{id}/update")
    public String updateBlogPage(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("types", typeService.getAdminType());
        model.addAttribute("tags", tagService.listTags());
        return "admin/blogs-update";
    }

    @PostMapping(value = "/blogs/update")
    public String updateBlog(RedirectAttributes redirectAttributes, BlogShow blogShow) {
        /*逻辑混乱：没有固定的标志确定编辑后的博客是否与数据库中的重复（这里只是拿id暂时判定）*/
        Blog updateBlogById = blogService.getBlogById(blogShow.getId());
        if (updateBlogById != null) {
            int editBlogCount = blogService.updateBlog(blogShow);
            if (editBlogCount > 0) {
                redirectAttributes.addFlashAttribute("message", "更新成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "更新成功");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "博客已存在");
            return "redirect:/admin/blogs/input";
        }
        return "redirect:/admin/blogs";
    }

    /*----------------删除-------------------*/

    @GetMapping(value = "/blogs/{id}/delete")
    public String deleteBlog(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlogById(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/blogs";
    }


    /*---------------搜索-------------------*/

    @PostMapping(value = "/blogs/search")
    public String searchBlog(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model, BlogSearch blogSearch) {
        /*强制类型转换*/
        blogService.transFormRecomment(blogSearch);
        /*查询陈列*/
        List<BlogQuery> blogQueries = blogService.getBlogSearch(blogSearch);
        String orderBy = "id asc";
        PageHelper.startPage(pageNum,5,orderBy);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueries);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types", typeService.getAdminType());
        model.addAttribute("tags", tagService.listTags());
        return "admin/blogs";
    }


}
