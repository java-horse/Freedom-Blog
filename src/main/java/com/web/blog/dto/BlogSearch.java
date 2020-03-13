package com.web.blog.dto;

import java.io.Serializable;

/**
 * @author mabin
 * @date 2020/2/20 20:21
 */
public class BlogSearch implements Serializable {

    private String title;

    private Long typeId;

    private String recommend;

    private Integer recommendButtom;

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

    public Integer getRecommendButtom() {
        return recommendButtom;
    }

    public void setRecommendButtom(Integer recommendButtom) {
        this.recommendButtom = recommendButtom;
    }

    @Override
    public String toString() {
        return "BlogSearch{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend='" + recommend + '\'' +
                ", recommendButtom=" + recommendButtom +
                '}';
    }
}
