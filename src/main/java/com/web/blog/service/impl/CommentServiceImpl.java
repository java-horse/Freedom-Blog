package com.web.blog.service.impl;

import com.web.blog.bean.Comment;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.mapper.CommentMapper;
import com.web.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/23 16:32
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BlogMapper blogMapper;


    /**
     * @param comment
     * 保存评论（逻辑正确，层级关系正确）
     */
    @Override
    public void saveComment(Comment comment) {
        //判断有没有在别人的评论上进行评论还是一个新的评论
        Long parentCommentId = comment.getParentCommentId();
        //没有父级评论默认是-1
        if (parentCommentId != -1) {
            //有父级评论
            comment.setParentComment(commentMapper.findByParentCommentId(comment.getParentCommentId()));
        } else {
            comment.setParentComment(null);
        }
        commentMapper.saveComment(comment);
    }

    /**
     * 评论展示(整体逻辑生效)
     * @param blogId
     * @return
     */
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        ArrayList<Comment> comments = new ArrayList<>();
        List<Comment> commentParent = commentMapper.getCommentParent(blogId);
        for (Comment comment : commentParent) {
            List<Comment> replyComments = commentMapper.getReplyComments(comment.getId());
            comment.setReplyComments(replyComments);
            comments.add(comment);
        }
        return eachComment(comments);
    }


    /*====================下面两个使管理评论内容的方法=================*/

    @Override
    public List<Comment> listComments() {
        return commentMapper.listComments();
    }

    @Override
    public int deleteCommentById(Long id) {
        return commentMapper.deleteCommentById(id);
    }

    /*-------------------------辅助方法（不太懂,并且没有将各个父类评论下的子级评论获取出来）------------------------*/

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        //复制一个新的list集合，防止在元数据发生错误
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    /**
     *
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {

            List<Comment> replys1 = comment.getReplyComments();

            for(Comment reply1 : replys1) {

                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param comment 被迭代的对象
     * @return
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);//顶节点（每个父评论下的第一个子评论）添加到临时存放集合
        if (comment.getReplyComments().size()>0) {
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }
}
