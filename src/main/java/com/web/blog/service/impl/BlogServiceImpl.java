package com.web.blog.service.impl;

import com.web.blog.bean.Blog;
import com.web.blog.bean.Tag;
import com.web.blog.dto.*;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.service.BlogService;
import com.web.blog.service.TagService;
import com.web.blog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author mabin
 * @date 2020/2/19 14:31
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagService tagService;

    @Transactional
    @Override
    public List<BlogQuery> listBlog() {
        return blogMapper.listBlog();
    }

    @Transactional
    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        /*发布博客设置随机浏览数据*/
        blog.setViews(new Random().nextInt(991) + 10);
        /*向t_blog_tags表中保存相应的信息(不知道为什么，数据库中没有添加信息)*/
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogMapper.saveBlogAndTag(blogAndTag);
        }
        return blogMapper.saveBlog(blog);
    }

    @Transactional
    @Override
    public int updateBlog(BlogShow blogShow) {
        blogShow.setUpdateTime(new Date());
        return blogMapper.updateBlog(blogShow);
    }

    @Transactional
    @Override
    public void deleteBlogById(Long id) {
        blogMapper.deleteBlogById(id);
    }

    @Override
    public void transFormRecomment(BlogSearch blogSearch) {
        if (!"".equals(blogSearch.getRecommend()) && blogSearch.getRecommend() != null) {
            blogSearch.setRecommendButtom(1);
        }
    }

    @Override
    public List<BlogQuery> getBlogSearch(BlogSearch blogSearch) {
        return blogMapper.getBlogSearch(blogSearch);
    }

    /*-------------------index------------------*/

    @Override
    public List<BlogIndexShow> getBlogIndexShow() {
        return blogMapper.getBlogIndexShow();
}

    /**
     * 判断recommend是否为true,决定是否推荐到index页面
     * @return
     */
    @Override
    public List<BlogRecommend> getBlogRecommend() {
        List<BlogRecommend> blogRecommend = blogMapper.getBlogRecommend();
        ArrayList<BlogRecommend> recommends = new ArrayList<>();
        for (BlogRecommend recommend : blogRecommend) {
            if (recommend.isRecommend()) {
                recommends.add(recommend);
            }
        }
        return recommends;
    }

    @Override
    public List<Blog> listBlogByTypeId(Long id) {
        return blogMapper.listBlogByTypeId(id);
    }

    @Override
    public List<Blog> listBlogByTagId(Long tagId) {
        return blogMapper.listBlogByTagId(tagId);
    }

    @Override
    public List<BlogIndexShow> getBlogIndexSearch(String query) {
        return blogMapper.getBlogIndexSearch(query);
    }

    /**
     * 博客详情页
     * @param id
     * @return
     */
    @Override
    public BlogDetail getBlogDetail(Long id) {
        BlogDetail blogDetail = blogMapper.getBlogDetail(id);
        /*每次查看博客详情，views 加 1*/
        blogMapper.getBlogViews(id);
        /*获取博客的所有标签*/
        ArrayList<Tag> tags = new ArrayList<>();
        List<Tag> tagsString = tagService.getTagsString(blogDetail.getTagIds());
        for (Tag tag : tagsString) {
            tags.add(tag);
        }
        blogDetail.setTags(tags);
        /*Markdown转html*/
        blogDetail.setContent(MarkdownUtils.markdownToHtmlExtensions(blogDetail.getContent()));
        return blogDetail;
    }

    /*----------------归档---------------------*/

    @Transactional
    @Override
    public Map<String, List<BlogShow>> archivesBlogs() {
        Map<String, List<BlogShow>> archivesBlogMap = new LinkedHashMap<>();
        List<String> blogYear = blogMapper.archivesBlogYear();
        for (String year : blogYear) {
            archivesBlogMap.put(year, blogMapper.archivesListBlog(year));
        }
        return archivesBlogMap;
    }

    @Override
    public int blogCount() {
        return blogMapper.blogCount();
    }


}
