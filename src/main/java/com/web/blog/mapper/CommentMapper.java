package com.web.blog.mapper;

import com.web.blog.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/23 16:24
 */
@Mapper
@Repository
public interface CommentMapper {

   public void saveComment(Comment comment);

   public Comment findByParentCommentId(Long parentCommentId);

   public List<Comment> getCommentParentCommentId(Long blogId);

   public List<Comment> listComments();

    public int deleteCommentById(Long id);

    /*public List<Comment> getReplyComments(Long parentId);*/


}
