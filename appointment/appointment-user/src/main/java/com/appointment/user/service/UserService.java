package com.appointment.user.service;

import com.appointment.common.utils.IdWorker;
import com.appointment.company.User;
import com.appointment.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserMapper userMapper;

    public void add(User user){
        //设置主键的值
        String id = idWorker.nextId()+"";
        user.setId(id);
        userMapper.insert(user);
    }

    public void delete(String id){
        userMapper.deleteById(id);
    }

    public User findById(String id){
        final User user = userMapper.selectById(id);
        return user;
    }

}
