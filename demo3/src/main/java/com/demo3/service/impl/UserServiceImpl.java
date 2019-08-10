package com.demo3.service.impl;

import com.demo3.dao.UserMapper;
import com.demo3.model.User;
import com.demo3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

//    @Autowired
//    private UserMapper userMapper;

      private UserMapper userMapper;

      public UserMapper getUserMapper(){
          return userMapper;
      }

      @Autowired
      public void setUserMapper(UserMapper userMapper){
          this.userMapper = userMapper;
      }

    @Override
    public List<User> loadUsers() {
        return userMapper.queryAll();
    }

}
