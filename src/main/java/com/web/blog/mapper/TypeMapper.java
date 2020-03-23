package com.web.blog.mapper;

import com.web.blog.bean.Type;
import com.web.blog.dto.BlogIndexShow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/15 22:22
 */
@Repository
@Mapper
public interface TypeMapper {

    /*---------------管理员分类-----------------*/

    /**
     * 保存分类信息
     * @param type
     * @return
     */
    @Insert("INSERT INTO t_type(name) values(#{name})")
    public int saveType(Type type);

    /**
     * 根据id查询分类信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_type WHERE id=#{id}")
    public Type getTypeById(@Param("id") Long id);

    /**
     * 根据name查询分类信息
     * @param name
     * @return
     */
    @Select("SELECT * FROM t_type WHERE name=#{name}")
    public Type getTypeByName(@Param("name") String name);

    /**
     * 查询后台所有分类信息
     * @return
     */
    @Select("select * from t_type t order by t.id asc limit 0, 6;")
    public List<Type> listTypes();


    @Select("select * from t_type;")
    public List<Type> getAdminType();

    /**
     * 根据id进行修改保存
     * @param type
     * @return
     */
    @Update("UPDATE t_type SET name=#{name} WHERE id=#{id}")
    public int updateType(Type type);

    /**
     * 根据id删除分类信息
     * @param id
     */
    @Delete("DELETE FROM t_type WHERE id=#{id}")
    public void deleteType(@Param("id") Long id);

    /*--------------公开分类-------------------------*/

    /**
     * Types详情页传递展示
     * @param id
     * @return
     */
    public List<BlogIndexShow> getBlogIndexShow(@Param("id") Long id);

}
