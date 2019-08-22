package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.user.Permission;
import com.appointment.user.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Api(value = "权限管理接口",description = "权限增删改查")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation("添加权限")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result add(Permission permission){
        permissionService.add(permission);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //根据角色id查询权限
//    @RequestMapping(value = "/findpermissions/{id}",method = RequestMethod.GET)
//    public Result findPermissionsByRoleId(@PathVariable String id){
//        List<Permission> permissions = permissionService.findPermissionsByRoleId(id);
//        Result result = new Result(ResultCode.SUCCESS);
//        result.setData(permissions);
//        return result;
//    }
    @RequestMapping(value = "/findpermissions/{id}",method = RequestMethod.GET)
    public List<Permission> findPermissionsByRoleId(@PathVariable String id){
        List<Permission> permissions = permissionService.findPermissionsByRoleId(id);
        return permissions;
    }

}
