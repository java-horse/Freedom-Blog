package com.web.blog.controller.admin;

import com.web.blog.bean.User;
import com.web.blog.service.LoginService;
import com.web.blog.utils.MD5ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author mabin
 * @date 2020/3/14 14:43
 */
@Controller
@RequestMapping("/admin")
public class UtilsController {

    @Autowired
    private LoginService loginService;

    /**
     * 跳转swagger-ui API页面
     * @return
     */
    @GetMapping(value = "/swagger")
    public String toSeaggerUI () {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping(value = "/editAdmin")
    public String toEditAdmin(Model model) {
        model.addAttribute("User",loginService.findUser());
        return "admin/editAdmin";
    }

    @PutMapping(value = "/editAdmin")
    public String editAdmin(User user, RedirectAttributes redirectAttributes) {
        if (!user.getPassword().equals(loginService.findUser().getPassword())) {
            user.setPassword(MD5ShiroUtils.MD5Code(user.getUsername(),user.getPassword()));
        }
        int count = loginService.updateAdmin(user);
        if (count > 0) {
            redirectAttributes.addFlashAttribute("message","用户信息更新成功");
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("message","用户信息更新失败");
            return "redirect:/admin/editAdmin";
        }
    }
}
