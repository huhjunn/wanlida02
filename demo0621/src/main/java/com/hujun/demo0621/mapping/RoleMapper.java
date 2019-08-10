package com.hujun.demo0621.mapping;

import com.hujun.demo0621.pojo.PeRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper
@Component
public interface RoleMapper {
    Set<PeRole> findByUsername(String username);
}
