package com.appointment.user.service;

import com.appointment.common.utils.IdWorker;
import com.appointment.user.Role;
import com.appointment.user.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IdWorker idWorker;

    public void add(Role role){
        String id = idWorker.nextId() + "";
        role.setId(id);
        roleMapper.insert(role);
    }

    public void delete(String id){
        roleMapper.deleteById(id);
    }

    public List<Role> findRolesByUserId(String id){
        List<Role> roles = roleMapper.findRolesByUserId(id);
        return roles;
    }
}
