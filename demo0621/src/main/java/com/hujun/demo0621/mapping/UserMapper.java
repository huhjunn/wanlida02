package com.hujun.demo0621.mapping;

import com.hujun.demo0621.pojo.PeUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    PeUser findByName(String username);

    List<PeUser> findAll();
}
