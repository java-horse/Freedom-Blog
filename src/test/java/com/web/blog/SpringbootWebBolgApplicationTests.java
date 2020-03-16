package com.web.blog;

import com.web.blog.bean.Blog;
import com.web.blog.bean.Tag;
import com.web.blog.bean.Type;
import com.web.blog.dto.BlogDetail;
import com.web.blog.dto.BlogIndexShow;
import com.web.blog.dto.BlogRecommend;
import com.web.blog.dto.BlogShow;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.mapper.TagMapper;
import com.web.blog.service.BlogService;
import com.web.blog.service.LoginService;
import com.web.blog.service.TagService;
import com.web.blog.service.TypeService;
import com.web.blog.utils.MD5ShiroUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

@SpringBootTest
class SpringbootWebBolgApplicationTests {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


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
        System.out.println(new Random().nextInt(64) + 800);

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
        map.put("ids", list);
        List<Blog> blogs = blogMapper.findBlogsByforEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test010() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "Mybatis原来如此神奇");
        map.put("flag", "转载");
        List<Blog> blogsByChoose = blogMapper.findBlogsByChoose(map);
        for (Blog blog : blogsByChoose) {
            System.out.println(blog);
        }
    }


    /**
     * 利用shiro的加密来生成密码
     */
    @Test
    public void test011() {
        //加密方式
        String hashAlgorithmName = "MD5";
        //加密次数
        int hashInteractions = 1024;
        //盐值
        String salt = "mabin";
        //原密码
        String pwd = "mabin123";
        //将得到的result放到数据库中就行了。
        String result = new SimpleHash(hashAlgorithmName, pwd, ByteSource.Util.bytes(salt), hashInteractions).toHex();
        String md5Code = MD5ShiroUtils.MD5Code(salt, pwd);
        System.out.println("加密后的密码：" + result);
        System.out.println(md5Code);
        if (result.equals(md5Code)) {
            System.out.println(true);
        }
    }

    @Test
    public void test12() {
        if (loginService.findUserByUsername("mabin").getPassword().equals(MD5ShiroUtils.MD5Code("mabin", "mabin123"))) {
            System.out.println("密码匹配成功");
        }
    }

    @Test
    public void test13() {
        List<Object> blogindexshow = redisTemplate.opsForList().range("blogindexshow", 0, -1);
        for (Object o : blogindexshow) {
            System.out.println(o);
        }
    }

}

