package com.web.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.blog.bean.Type;
import com.web.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author mabin
 * @date 2020/2/17 16:52
 */

@Controller
@RequestMapping(value = "/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 使用分页插件进行内容封装并跳转页面陈列显示
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/types")
    public String listTypes(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        /*按照id升序排列*/
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 8,orderBy);
        List<Type> adminType = typeService.getAdminType();
        //得到分页结果对象并封装
        PageInfo<Type> pageInfo = new PageInfo<>(adminType);

        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    /*-------------------新增-----------------*/

    @GetMapping(value = "/types/input")
    public String inputTypesPage() {
        return "admin/types-input";
    }

    /**
     * 新增分类名称
     * @param type
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/types")
    public String addTypesName(Type type, RedirectAttributes redirectAttributes) {
        /*判断新增名称是否已存在*/
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName == null) {
            Integer saveCount = typeService.saveType(type);
            if (saveCount >= 1) {
                redirectAttributes.addFlashAttribute("message", "新增成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "新增失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "分类名称已存在");
            return "redirect:/admin/types/input";
        }
        return "redirect:/admin/types";
    }


    /*-------------------更新-----------------*/

    @GetMapping(value = "/types/{id}")
    public String editTypePage(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("type", typeService.getTypeById(id));
        return "admin/types-update";
    }

    /**
     * 编辑分类名称
     * @param type
     * @param redirectAttributes
     * @return
     */
    @PutMapping(value = "/types")
    public String editTypesName(Type type, RedirectAttributes redirectAttributes) {
        /*判断修改后的名称是否已存在（MySQL默认不区分大小写）*/
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName == null) {
            int updateType = typeService.updateType(type);
            if (updateType > 0) {
                redirectAttributes.addFlashAttribute("message", "更新成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "更新失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "分类名称已存在");
            return "redirect:/admin/types/input";
        }
        return "redirect:/admin/types";
    }

    /*-------------------删除-----------------*/

    @DeleteMapping(value = "/types/{id}")
    public String deleteTypePage(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }

}
