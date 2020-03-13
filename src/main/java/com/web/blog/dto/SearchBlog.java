package com.web.blog.dto;

import java.io.Serializable;

/**
 * @author mabin
 * @date 2020/2/19 16:15
 */
public class SearchBlog implements Serializable {

    private String title;

    private Long typeId;

    /*推荐符号从前端传过来是String类型*/

    private String recommend;

    private Integer recommend2;

    public SearchBlog() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getRecommend2() {
        return recommend2;
    }

    public void setRecommend2(Integer recommend2) {
        this.recommend2 = recommend2;
    }
}
