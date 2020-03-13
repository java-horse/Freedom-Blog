package com.web.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Type;
import com.web.blog.dto.BlogIndexShow;
import com.web.blog.service.BlogService;
import com.web.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabin
 * @date 2020/2/24 15:47
 */
@Controller
public class TypeShowConreoller {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/types/{id}")
    public String types(@PathVariable(value = "id") Long id, Model model,
                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "update_time desc";
        ArrayList<Type> types = new ArrayList<>();
        List<Type> arrayList = typeService.getAdminType();
        /*当导航栏跳转分类页面时，指定显示为：t_type表中的第一条分类的信息*/
        if (id == -1) {
            id = arrayList.get(0).getId();
        }
        /*根据type中的id连表查询并设置每种type中有多少条blog内容*/
        for (Type type : arrayList) {
            type.setBlogs(blogService.listBlogByTypeId(type.getId()));
            types.add(type);
        }
        PageHelper.startPage(pageNum,6,orderBy);
        PageInfo<BlogIndexShow> pageInfo = new PageInfo<>(typeService.getBlogIndexShow(id));
        model.addAttribute("types",types);
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("activeTypeId",id);
        return "types";
    }

}
