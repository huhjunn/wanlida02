package com.hujun.demo0621.mapping;

import com.hujun.demo0621.pojo.PePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper
public interface PermissionMapper {
    Set<PePermission> findByRole(String role);
}
