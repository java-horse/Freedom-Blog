package com.web.blog.service;

import com.web.blog.bean.Comment;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/23 16:32
 */
public interface CommentService {

    public void saveComment(Comment comment);

    public List<Comment> listCommentByBlogId(Long blogId);


    public List<Comment> listComments();

    public int deleteCommentById(Long id);
}
