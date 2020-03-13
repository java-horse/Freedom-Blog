package com.web.blog.mapper;

import com.web.blog.bean.Tag;
import com.web.blog.dto.BlogDetail;
import com.web.blog.dto.BlogIndexShow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/18 17:40
 */
@Repository
@Mapper
public interface TagMapper {

    @Select("SELECT * FROM t_tag WHERE id=#{id}")
    public Tag getTagsById(Long id);

    @Select("SELECT * FROM t_tag WHERE name=#{name}")
    public Tag getTagsByName(String name);

    @Select("select * from t_tag t order by t.id asc;")
    public List<Tag> listTags();

    @Select("select * from t_tag t order by t.id asc limit 0, 10;")
    public List<Tag> getAdminTags();

    @Insert("INSERT INTO t_tag (name) VALUES (#{name})")
    public int saveTags(Tag tag);

    @Update("UPDATE t_tag SET name=#{name} WHERE id=#{id}")
    public int updateTags(Tag tag);

    @Delete("DELETE FROM t_tag WHERE id=#{id}")
    public  void deleteTags(Long id);


    /*----------tags详情页------------------*/
    public List<BlogDetail> getBlogDetail(Long tagId);

}
