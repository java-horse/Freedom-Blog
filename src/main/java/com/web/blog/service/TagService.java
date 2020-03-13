package com.web.blog.service;

import com.web.blog.bean.Tag;
import com.web.blog.dto.BlogDetail;
import com.web.blog.dto.BlogIndexShow;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/18 17:44
 */
public interface TagService {

    public Tag getTagsById(Long id);

    public Tag getTagsByName(String name);

    public List<Tag> listTags();

    public List<Tag> getAdminTags();

    public int saveTags(Tag tag);

    public int updateTags(Tag tag);

    public  void deleteTags(Long id);

    public List<Tag> getTagsString(String tagIds);

    public List<BlogDetail> getBlogDetail(Long tagId);

}
