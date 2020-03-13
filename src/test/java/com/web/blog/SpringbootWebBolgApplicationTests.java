package com.web.blog;

import com.web.blog.bean.Blog;
import com.web.blog.bean.Tag;
import com.web.blog.bean.Type;
import com.web.blog.dto.*;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.mapper.CommentMapper;
import com.web.blog.mapper.TagMapper;
import com.web.blog.service.BlogService;
import com.web.blog.service.TagService;
import com.web.blog.service.TypeService;
import com.web.blog.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringbootWebBolgApplicationTests {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Autowired
    private TagService tagService;


    @Test
    void contextLoads() {
        List<Type> adminType = typeService.getAdminType();
        for (Type type : adminType) {
            System.out.println(type);
        }
    }

    @Test
    public void getBlogIndexShow() {
        List<BlogIndexShow> blogIndexShow = blogService.getBlogIndexShow();
        for (BlogIndexShow indexShow : blogIndexShow) {
            System.out.println(indexShow);
        }
    }

    @Test
    public void test() {
        System.out.println(new Random().nextInt(64)+800);

    }

    @Test
    public void test002() {
        List<BlogDetail> blogDetail = tagService.getBlogDetail(7L);
        for (BlogDetail detail : blogDetail) {
            System.out.println(detail);
        }
    }

    @Test
    public void test003() {
        Map<String, List<BlogShow>> map = blogService.archivesBlogs();
        for (String s : map.keySet()) {
            List<BlogShow> blogShows = map.get(s);
            for (BlogShow blogShow : blogShows) {
                System.out.println(blogShow.getTitle());
            }
        }
    }

    @Test
    public void test004() {
        List<Type> adminType = typeService.getAdminType();
        for (Type type : adminType) {
            System.out.println(type);
        }
    }

    @Test
    public void test005() {
        List<Tag> tags = tagMapper.listTags();
        for (Tag tag : tags) {
            System.out.println(tag);
        }
    }

    @Test
    public void test006() {
        List<BlogRecommend> blogRecommend = blogMapper.getBlogRecommend();
        for (BlogRecommend recommend : blogRecommend) {
            System.out.println(recommend);
        }
    }

    @Test
    public void test007() {
        List<BlogIndexShow> blogIndexShow = blogService.getBlogIndexShow();
        for (BlogIndexShow indexShow : blogIndexShow) {
            System.out.println(indexShow);
        }
    }

    @Test
    public void test008() {
        List<String> strings = blogMapper.archivesBlogYear();
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test009() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("ids",list);
        List<Blog> blogs = blogMapper.findBlogsByforEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test010() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title","Mybatis原来如此神奇");
        map.put("flag","转载");
        List<Blog> blogsByChoose = blogMapper.findBlogsByChoose(map);
        for (Blog blog : blogsByChoose) {
            System.out.println(blog);
        }
    }

}

