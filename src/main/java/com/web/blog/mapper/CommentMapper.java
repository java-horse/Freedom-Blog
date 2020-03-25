package com.web.blog.mapper;

import com.web.blog.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

   public Comment findByParentCommentId(@Param("parentCommentId") Long parentCommentId);

   public List<Comment> getCommentParentCommentId(@Param("blogId") Long blogId);

   public List<Comment> listComments();

    public int deleteCommentById(@Param("id") Long id);

}
