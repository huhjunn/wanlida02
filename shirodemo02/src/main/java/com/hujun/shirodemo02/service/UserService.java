package com.hujun.shirodemo02.service;

import com.hujun.shirodemo02.mapper.UserMapper;
import com.hujun.shirodemo02.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByName(String name) {
        return this.userMapper.findByName(name);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

}
