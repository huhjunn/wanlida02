package com.appointment.user.mapper;

import com.appointment.user.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

     public List<Role> findRolesByUserId(String id);
}
