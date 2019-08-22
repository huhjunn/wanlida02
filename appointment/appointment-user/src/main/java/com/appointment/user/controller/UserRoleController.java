package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.user.UserRole;
import com.appointment.user.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userrole")
@Api(value = "用户与角色关系接口",description = "角色分配管理")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    //给用户分配角色
    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result assignRole(@RequestBody UserRole userRole){
        userRoleService.add(userRole);

        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //查询用户角色id
    public List<String> find(String id){
        List<String> roleId = userRoleService.findRoleId(id);
        return roleId;
    }
}
