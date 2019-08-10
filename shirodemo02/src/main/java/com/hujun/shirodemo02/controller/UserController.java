package com.hujun.shirodemo02.controller;

import com.hujun.shirodemo02.pojo.User;
import com.hujun.shirodemo02.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("/aa")
    public String aa(){
        return "bb";
    }

    @RequestMapping("/login")
    public String login(String username,String password){

        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken uptoken = new UsernamePasswordToken(username,password);
            subject.login(uptoken);
            return "登录成功";
        }catch (Exception e) {
            return "用户名或密码错误";
        }

    }

}
