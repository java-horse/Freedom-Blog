package com.web.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.dto.BlogDetail;
import com.web.blog.dto.BlogIndexShow;
import com.web.blog.dto.BlogRecommend;
import com.web.blog.service.BlogService;
import com.web.blog.service.CommentService;
import com.web.blog.service.TagService;
import com.web.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/21 16:39
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    /**
     * 此接口代码过于冗余，应该还有其他方法实现（一些逻辑可以在service层实现）
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String toIndex(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogIndexShow> blogIndexShow = blogService.getBlogIndexShow();
        PageInfo<BlogIndexShow> pageInfo = new PageInfo<>(blogIndexShow);
        model.addAttribute("pageInfo", pageInfo);
        /*在index页面页面上分类(type)取前6种即可(service实现逻辑控制)*/
        model.addAttribute("types", typeService.listTypes());
        /*在index页面上标签（tag）取前10个*/
        model.addAttribute("tags", tagService.getAdminTags());
        /*在index页面上推荐标题（recommend）取前8个*/
        model.addAttribute("blogRecommends", blogService.getBlogRecommend());
        return "index";
    }

    /*------------------全局搜索------------------------*/

    @PostMapping(value = "/search")
    public String searchBlog(@RequestParam(value = "query") String query,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             Model model) {
        /*如果query为null,就直接重定向到index页面，不在跳转到search页面*/
        if (query == null || "".equals(query)) {
            return "redirect:/;";
        }
        PageHelper.startPage(pageNum, 6);
        List<BlogIndexShow> blogIndexSearch = blogService.getBlogIndexSearch(query);
        PageInfo<BlogIndexShow> pageInfo = new PageInfo<>(blogIndexSearch);
        model.addAttribute("pageInfo", pageInfo);
        return "search";
    }

    /*-----------------blog详情页---------------------------*/

    @GetMapping(value = "/blog/{id}")
    public String blogDetail(@PathVariable(value = "id") Long id, Model model) {
        BlogDetail blogDetail = blogService.getBlogDetail(id);
        model.addAttribute("blog", blogDetail);
        model.addAttribute("comments", commentService.listCommentByBlogId(id));
        return "blog";
    }

    /*---------------------fragment模板页面中的footer部分展示（使用Jquery技术进行链接访问）-----------------*/

    @GetMapping(value = "/footer/newblogs")
    public String newBlogs(Model model) {
        ArrayList<BlogRecommend> recommends = new ArrayList<>();
        List<BlogRecommend> blogRecommend = blogService.getBlogRecommend();
        for (BlogRecommend recommend : blogRecommend) {
            recommends.add(recommend);
            if (recommends.size() >= 3) {
                break;
            }
        }
        model.addAttribute("newBlogs", recommends);
        return "fragment :: newBlogList";
    }


}
