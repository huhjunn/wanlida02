package com.appointment.user.service;

import com.appointment.user.UserRole;
import com.appointment.user.mapper.UserRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public void add(UserRole userRole){
        userRoleMapper.insert(userRole);
    }

    public List<String> findRoleId(String userId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId);
        List<UserRole> userRoles = userRoleMapper.selectList(queryWrapper);
        List<String> roleIds = new ArrayList<>();
        for(UserRole userRole : userRoles){
            String roleId = userRole.getRoleId();
            roleIds.add(roleId);
        }
        return roleIds;
    }
}
