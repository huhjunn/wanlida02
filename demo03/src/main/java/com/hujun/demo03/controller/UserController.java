package com.hujun.demo03.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
