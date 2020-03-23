package com.web.blog.service.impl;

import com.web.blog.bean.Blog;
import com.web.blog.bean.Tag;
import com.web.blog.dto.BlogDetail;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.mapper.TagMapper;
import com.web.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


/**
 * @author mabin
 * @date 2020/2/18 17:45
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogMapper blogMapper;


    @Transactional
    @Override
    public Tag getTagsById(Long id) {
        return tagMapper.getTagsById(id);
    }

    @Transactional
    @Override
    public Tag getTagsByName(String name) {
        return tagMapper.getTagsByName(name);
    }

    @Transactional
    @Override
    public List<Tag> listTags() {
        ArrayList<Tag> tags = new ArrayList<>();
        List<Tag> listTags = tagMapper.listTags();
        for (Tag tag : listTags) {
            tag.setBlogs(blogMapper.listBlogByTagId(tag.getId()));
            tags.add(tag);
        }
        return listTags;
    }

    @Override
    public List<Tag> getAdminTags() {
        return tagMapper.getAdminTags();
    }

    @Transactional
    @Override
    public int saveTags(Tag tag) {
        return tagMapper.saveTags(tag);
    }

    @Transactional
    @Override
    public int updateTags(Tag tag) {
        return tagMapper.updateTags(tag);
    }

    @Override
    @Transactional
    public void deleteTagsById(Long id, RedirectAttributes redirectAttributes) {
       List<Blog> blogList = blogMapper.findBlogsByTagId(id);
       if (blogList.size() > 0) {
           redirectAttributes.addFlashAttribute("errorMessage","此标签有关联的博客，不允许删除！");
       } else {
           tagMapper.deleteTags(id);
           redirectAttributes.addFlashAttribute("message","删除成功");
       }
    }

    @Transactional
    @Override
    public List<BlogDetail> getBlogDetail(Long tagId) {
        ArrayList<BlogDetail> blogDetails = new ArrayList<>();
        List<BlogDetail> blogDetail = tagMapper.getBlogDetail(tagId);
        /*设置每个博客中的tag*/
        for (BlogDetail detail : blogDetail) {
            detail.setTags(getTagsString(detail.getTagIds()));
            blogDetails.add(detail);
        }
        return blogDetails;
    }

    /*-------------辅助方法---------------*/

    @Override
    public List<Tag> getTagsString(String tagIds) {
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(tagIds);
        for (Long longId : longs) {
            tags.add(tagMapper.getTagsById(longId));
        }
        return tags;
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

}
