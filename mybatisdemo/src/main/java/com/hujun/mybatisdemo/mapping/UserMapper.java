package com.hujun.mybatisdemo.mapping;

import com.hujun.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    public List<User> queryUserList();
}
