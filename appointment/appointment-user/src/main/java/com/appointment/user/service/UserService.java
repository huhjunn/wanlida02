package com.appointment.user.service;

import com.appointment.common.utils.IdWorker;
import com.appointment.user.User;
import com.appointment.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

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

        //密码加密
        String phone = user.getPhone();
        String password = user.getPassword();
        password = new Md5Hash(password,phone,3).toString();
        user.setPassword(password);

        userMapper.insert(user);
    }

    public void delete(String id){
        userMapper.deleteById(id);
    }

    public User findById(String id){
        final User user = userMapper.selectById(id);
        return user;
    }

    public User findByPhone(String phone){
        QueryWrapper queryWrapper = new QueryWrapper(new User());
        queryWrapper.eq("phone",phone);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }
}
