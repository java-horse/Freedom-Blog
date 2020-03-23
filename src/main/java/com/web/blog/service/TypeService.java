package com.web.blog.service;

import com.web.blog.bean.Type;
import com.web.blog.dto.BlogIndexShow;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/15 22:10
 */
public interface TypeService {

    public int saveType(Type type);

    public Type getTypeById(Long id);

    public Type getTypeByName(String name);

    public List<Type> listTypes();

    public List<Type> getAdminType();

    public int updateType(Type type);


    /*----------types详情页-----------------*/

    public List<BlogIndexShow> getBlogIndexShow(Long id);

    void deleteTypeById(Long id, RedirectAttributes redirectAttributes);
}
