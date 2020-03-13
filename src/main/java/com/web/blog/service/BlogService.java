package com.web.blog.service;

import com.web.blog.bean.Blog;
import com.web.blog.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author mabin
 * @date 2020/2/19 14:31
 */
public interface BlogService {

    public List<BlogQuery> listBlog();

    public Blog getBlogById(Long id);

    public int saveBlog(Blog blog);

    public int updateBlog(BlogShow blogShow);

    public void deleteBlogById(Long id);

    public void transFormRecomment(BlogSearch blogSearch);

    public List<BlogQuery> getBlogSearch(BlogSearch blogSearch);

    /*----------------index--------------------*/
    public List<BlogIndexShow> getBlogIndexShow();

    public List<BlogRecommend> getBlogRecommend();

    public List<Blog> listBlogByTypeId(Long id);

    public List<Blog> listBlogByTagId(Long tagId);

    public List<BlogIndexShow> getBlogIndexSearch(String query);

    public BlogDetail getBlogDetail(Long id);

    /*---------------归档------------------------*/

    public Map<String, List<BlogShow>> archivesBlogs();

    public int blogCount();
}
