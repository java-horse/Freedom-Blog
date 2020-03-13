package com.web.blog.dto;

/**
 * @author mabin
 * @date 2020/2/20 11:56
 */
public class BlogAndTag {

    private Long blogId;

    private Long tagId;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public BlogAndTag(Long blogId, Long tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "BlogAndTag{" +
                "blogId=" + blogId +
                ", tagId=" + tagId +
                '}';
    }
}
