package com.web.blog.controller.admin;

import com.web.blog.service.LoginService;
import com.web.blog.utils.KaptchaUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


/**
 * @author mabin
 * @date 2020/2/15 15:22
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    private String avatar = "https://i.picsum.photos/id/" + (new Random().nextInt(64) + 800) + "/" + 900 + "/" + 500 + ".jpg";

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String toLogin() {
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes, Model model,
                        HttpServletRequest request) {
        /*获取当前用户的信息并封装*/
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //登录后首先进行验证码验证
            model.addAttribute("image", avatar);
            if (!KaptchaUtils.checkVerifyCode(request)) {
                redirectAttributes.addFlashAttribute("message", "验证码错误");
                return "redirect:/admin";
            }
            return "admin/index";
        } catch (UnknownAccountException e) { //注意：下面如果是重定向，这里不适用Model，而是使用RedirectAttribute
            redirectAttributes.addFlashAttribute("message", "用户名不存在");
            return "redirect:/admin";
        } catch (IncorrectCredentialsException e) {
            redirectAttributes.addFlashAttribute("message", "密码错误");
            return "redirect:/admin";
        }

    }

    @GetMapping(value = "/unauthorized")
    public String toUnauthorized() {
        return "error/unauthorized";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/admin";
    }

    /**
     * ajax简单登陆提示效果
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/userPass")
    public String userPass(String username, String password) {
        String message = "";
        if (!"".equals(username) & username != null) {
            if (loginService.findUserByUsername(username) != null) {
                if (loginService.findUserByUsername(username).getUsername().equals(username)) {
                    message = "用户名正确";
                }
            } else {
                message = "用户名错误";
            }
        }
        if (!"".equals(password) & password != null) {
            if (loginService.findUserByPassword(password) != null) {
                if (loginService.findUserByPassword(password).getPassword().equals(password)) {
                    message = "密码正确";
                }
            } else {
                message = "密码错误";
            }
        }
        return message;
    }

}
