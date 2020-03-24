package com.web.blog.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.web.blog.bean.User;
import com.web.blog.service.LoginService;
import com.web.blog.utils.FileUploadUtils;
import com.web.blog.utils.MD5ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author mabin
 * @date 2020/3/14 14:43
 */
@Controller
@RequestMapping("/admin")
public class UtilsController {

    @Autowired
    private LoginService loginService;


    //进行配置文件获取参数值的时候，不能使用static修饰
    @Value("${imageURL}")
    private String imageURL;
    @Value("${avatarImageURL}")
    private String avatarImageURL;

    //使用硬盘路径替代path，防止重新部署Tomcat项目图片丢失，此处tomcat已经docbase指向了"D:/**"
    @Value("${imagePath}")
    private String path;

    @Value("${avatarImagePath}")
    private String avatarImagePath;

    /**
     * 跳转swagger-ui API页面
     *
     * @return
     */
    @GetMapping(value = "/swagger")
    public String toSeaggerUI() {
        return "redirect:/swagger-ui.html";
    }

    /**
     * 修改用户信息，包括用户昵称，密码等等
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/editAdmin")
    public String toEditAdmin(Model model) {
        model.addAttribute("User", loginService.findUser());
        return "admin/editAdmin";
    }

    @PutMapping(value = "/editAdmin")
    public String editAdmin(User user, RedirectAttributes redirectAttributes) {
        if (!user.getPassword().equals(loginService.findUser().getPassword())) {
            user.setPassword(MD5ShiroUtils.MD5Code(user.getUsername(), user.getPassword()));
        }
        int count = loginService.updateAdmin(user);
        if (count > 0) {
            redirectAttributes.addFlashAttribute("message", "用户信息更新成功");
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户信息更新失败");
            return "redirect:/admin/editAdmin";
        }
    }

    /**
     * markdown实现图片上传回显
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/imageUpload")
    @ResponseBody
    public JSONObject imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                                  HttpServletRequest request) {
        //上传的原文件名
        String trueFileName = file.getOriginalFilename();
        //后缀名
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        //重新命名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        //io
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        JSONObject res = new JSONObject();
        try {
            file.transferTo(targetFile);
            //动态的获取访问站点
            res.put("url", FileUploadUtils.getImagePath(request) + imageURL + fileName);
            res.put("success", 1);
            res.put("message", "上传成功！");
        } catch (Exception e) {
            res.put("success", 0);
            res.put("message", "上传失败！");
            e.printStackTrace();
        }
        //返回给前端json对象
        return res;
    }


    /**
     * 更新头像
     * @param model
     * @return
     */
    @GetMapping(value = "/avatar")
    public String toEditAvatar(Model model) {
        model.addAttribute("User", loginService.findUser());
        return "admin/editAvatar";
    }

    @PostMapping(value = "/avatar")
    public String editAvatar(@RequestParam("file") MultipartFile file, Integer id,
                             RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //获取源文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //重命名文件
        String newFileName = UUID.randomUUID().toString().replaceAll("-","") + suffix;
        //io传送
        File targetFile = new File(avatarImagePath, newFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            //获取头像的URL
            String avatarURL = FileUploadUtils.getImagePath(request) + avatarImageURL + newFileName;
            //修改数据库头像的URL
            loginService.updateUserAvatar(id,avatarURL);
            redirectAttributes.addFlashAttribute("message","头像更新成功，再次登录更新...");
            return "redirect:/admin/blogs";
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message","头像更新失败，请联系管理员...");
            return "redirect:/admin/blogs";
        }
    }

}
