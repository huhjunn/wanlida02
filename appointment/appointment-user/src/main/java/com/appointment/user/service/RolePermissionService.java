package com.appointment.user.service;

import com.appointment.user.Role;
import com.appointment.user.RolePermission;
import com.appointment.user.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public void add(RolePermission rolePermission){
        rolePermissionMapper.insert(rolePermission);
    }
}
