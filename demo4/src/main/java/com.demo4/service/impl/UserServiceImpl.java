package com.demo4.service.impl;

import com.demo4.mapper.UserMapper;
import com.demo4.pojo.User;
import com.demo4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
