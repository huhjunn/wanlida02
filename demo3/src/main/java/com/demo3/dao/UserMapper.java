package com.demo3.dao;

import com.demo3.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    void insert(User user);

    List<User> queryAll();
}
