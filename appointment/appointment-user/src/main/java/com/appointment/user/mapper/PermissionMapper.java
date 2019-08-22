package com.appointment.user.mapper;

import com.appointment.user.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    public List<Permission> findPermissionsByRoleId(String id);
}
