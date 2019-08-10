package com.example.service;

import com.example.entity.User;
import com.example.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {


    /**
     * 注入dao
     */
    @Autowired
    private userMapper usermapper;

    //用户登录
    public User userLogin(String username,String password){
        User user = usermapper.userlogin(username,password);
        return user;
    }

    //注册新用户
    public int adduser(String username,String password){


        return usermapper.adduser(username,password);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }

}
