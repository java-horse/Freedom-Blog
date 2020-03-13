package com.web.blog.mapper;

import com.web.blog.bean.Blog;
import com.web.blog.dto.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author mabin
 * @date 2020/2/19 21:47
 */
@Repository
@Mapper
public interface BlogMapper {

    public List<BlogQuery> listBlog();

    @Select("SELECT * FROM t_blog WHERE id=#{id}")
    public Blog getBlogById(Long id);

    @Insert(" INSERT INTO t_blog (title, content, first_picture, flag,\n" +
            " views, appreciation, share_statement, releaseComment,published,\n" +
            " recommend, create_time, update_time, type_id,tag_ids, user_id, description)\n" +
            " VALUES (#{title},#{content},#{firstPicture},#{flag},#{views},#{appreciation},\n" +
            " #{shareStatement},#{releaseComment},#{published},#{recommend},#{createTime},\n" +
            " #{createTime},#{typeId},#{tagIds},#{userId},#{description});")
    public int saveBlog(Blog blog);

    @Insert("INSERT INTO t_blog_tags (tag_id,blog_id) VALUES (tag_id=#{tagId},blog_id=#{blogId})")
    public void saveBlogAndTag(BlogAndTag blogAndTag);

    @Update("UPDATE t_blog SET title=#{title},content=#{content},first_picture=#{firstPicture},flag=#{flag}," +
            "appreciation=#{appreciation},share_statement=#{shareStatement},releaseComment=#{releaseComment}," +
            "published=#{published},recommend=#{recommend},update_time=#{updateTime}," +
            "type_id=#{typeId},tag_ids=#{tagIds},description=#{description} WHERE id=#{id}")
    public int updateBlog(BlogShow blogShow);

    @Delete("DELETE FROM t_blog WHERE id=#{id}")
    public void deleteBlogById(Long id);


    public List<BlogQuery> getBlogSearch(BlogSearch blogSearch);


    /*-----------------index--------------------*/

    /**
     * 传递展示index页面的元素
     * @return
     */
    public List<BlogIndexShow> getBlogIndexShow();

    /**
     * 传递是否推荐（应用于最新推荐模块）
     * @return
     */
    @Select("SELECT id,title,recommend FROM t_blog ORDER BY update_time DESC LIMIT 0, 8")
    public List<BlogRecommend> getBlogRecommend();

    /**
     * 根据id（type.id也就是typeId）查询每种type.id对应的所有blog信息
     * @param typeId
     * @return
     */
    @Select("SELECT * FROM t_blog WHERE type_id=#{typeId}")
    public List<Blog> listBlogByTypeId(@Param("typeId") Long typeId);


    /**
     * 根据id（tag.id）模糊查询每种tag.id对应的所有blog信息
     * 注意：注解版的模糊查询一定要写 LIKE CONCAT('%',#{},'%')的形式，否则会报错
     * @param tagId
     * @return
     */
    @Select("select b.* from t_blog b where b.tag_ids like concat('%',#{tagId},'%')")
    public List<Blog> listBlogByTagId(Long tagId);


    /**
     * 全局搜索
     * @param query
     * @return
     */
    public List<BlogIndexShow> getBlogIndexSearch(String query);


    /**
     * 博客详情页
     * @param id
     * @return
     */
    public BlogDetail getBlogDetail(Long id);

    /**
     * 增加views
     * @param id
     * @return
     */
    @Update("update t_blog b set b.views=b.views+1 where id=#{id}")
    public int getBlogViews(Long id);

    /*--------------------归档------------------------*/

    public List<String> archivesBlogYear();

    public List<BlogShow> archivesListBlog(String year);

    @Select("select count(*) from t_blog")
    public int blogCount();

    /*------------------动态sql练习-----------------*/
    public List<Blog> findBlogsByforEach(Map<String,Object> map);

    public List<Blog> findBlogsByChoose(Map<String,Object> map);

}
