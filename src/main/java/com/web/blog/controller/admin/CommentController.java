package com.web.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Comment;
import com.web.blog.bean.User;
import com.web.blog.service.BlogService;
import com.web.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * @author mabin
 * @date 2020/2/23 15:17
 */
@Controller
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    /*直接赋值网图链接*/
    private String avatar = "https://i.picsum.photos/id/" + (new Random().nextInt(64)+800) + "/" + 100 + "/" + 100 + ".jpg";

    @GetMapping(value = "/admin/comments")
    public String comments(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum,10);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentService.listComments());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/comments";
    }

    @DeleteMapping(value = "/admin/comments/{id}")
    public String deleteComment(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        commentService.deleteCommentById(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/comments";
    }


    /**
     * 返回博客的具体评论信息
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping(value = "/comments/{blogId}")
    private String commentsDisplay(@PathVariable(value = "blogId") Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments",comments);
        model.addAttribute("blog",blogService.getBlogDetail(blogId));
        return "blog";
    }

    /**
     * 接收评论form表单并按逻辑保存
     * @param comment
     * @param session
     * @return
     */
    @PostMapping(value = "/comments")
    public String postComment(Comment comment, HttpSession session) {
        Long blogId = comment.getBlogId();
        /*设置Blog*/
        comment.setBlog(blogService.getBlogDetail(blogId));
        /*设置用户头像(只要登录后进行评论的，用户头像都是相同的 ，用户只有一个，所以头像都是一样的)*/
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            comment.setAvatar(loginUser.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
            comment.setAdminComment(false);
        }
        /*判断有无上层评论，并设置上层评论的id*/
        if (comment.getParentComment() != null) {
            comment.setParentCommentId(comment.getParentCommentId());
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}
