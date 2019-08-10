package com.demo4.controller;

import com.demo4.pojo.User;
import com.demo4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findUser/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable int userId){
        User user = iUserService.getUserById(userId);
        return user;
    }
}
