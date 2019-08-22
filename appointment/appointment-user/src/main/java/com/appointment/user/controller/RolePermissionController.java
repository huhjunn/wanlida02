package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.user.RolePermission;
import com.appointment.user.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result add(RolePermission rolePermission){
        rolePermissionService.add(rolePermission);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }
}
