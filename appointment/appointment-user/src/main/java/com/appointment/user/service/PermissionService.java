package com.appointment.user.service;

import com.appointment.common.utils.IdWorker;
import com.appointment.user.Permission;
import com.appointment.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private IdWorker idWorker;

    public void add(Permission permission){
        String id = idWorker.nextId() + "";
        permission.setId(id);
        permissionMapper.insert(permission);
    }

    public List<Permission> findPermissionsByRoleId(String id){
        return permissionMapper.findPermissionsByRoleId(id);
    }

}
