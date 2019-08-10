package com.demo3.controller;

import com.demo3.model.User;
import com.demo3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {

//    @Autowired
//    private IUserService userService;

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/showUser")
    public String showUsers(Model model){
        List<User> users = userService.loadUsers();
        model.addAttribute("user", users);
        return "showuser";
    }
}