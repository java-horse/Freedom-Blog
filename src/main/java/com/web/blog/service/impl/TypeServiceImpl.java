package com.web.blog.service.impl;

import com.web.blog.bean.Blog;
import com.web.blog.bean.Type;
import com.web.blog.dto.BlogIndexShow;
import com.web.blog.mapper.BlogMapper;
import com.web.blog.mapper.TypeMapper;
import com.web.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/15 22:21
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Transactional
    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Transactional
    @Override
    public List<Type> listTypes() {
        /*在index页面页面上分类(type)取前6种即可（后期可以在Service层进行逻辑控制）*/
        List<Type> adminType = typeMapper.getAdminType();
        ArrayList<Type> types = new ArrayList<>();
        for (Type type : adminType) {
            /*根据type中的id连表查询并设置每种type中有多少条blog内容*/
            type.setBlogs(blogMapper.listBlogByTypeId(type.getId()));
            types.add(type);
        }
        return types;
    }

    @Transactional
    @Override
    public List<Type> getAdminType() {
        return typeMapper.getAdminType();
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public List<BlogIndexShow> getBlogIndexShow(Long id) {
        return typeMapper.getBlogIndexShow(id);
    }

    @Override
    @Transactional
    public void deleteTypeById(Long id, RedirectAttributes redirectAttributes) {
        List<Blog> blogList = blogMapper.getBlogByTipeId(id);
        if (blogList.size() > 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "此类型有关联博客，不允许删除！");
        } else {
            typeMapper.deleteType(id);
            redirectAttributes.addFlashAttribute("message","删除成功！");
        }
    }

}
