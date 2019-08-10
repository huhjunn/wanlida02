package com.hujun.demo0621.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

    @RequestMapping(value="/login")
    @ResponseBody
    public String login(String username,String password) {
        try{
            /**
             *密码加密
             *shiro自带md5加密
             *参数一：加密内容 参数二：盐 参数三：加密次数
             */
            //password = new Md5Hash(password,username,3).toString();
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken uptoken = new UsernamePasswordToken(username,password);
            subject.login(uptoken);
            return "登录成功";
        }catch (Exception e) {
            return "用户名或密码错误";
        }
    }
}
