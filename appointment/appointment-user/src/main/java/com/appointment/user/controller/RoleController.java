package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.user.Role;
import com.appointment.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "角色管理接口",description = "角色增删改查")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //添加角色
    @ApiOperation("添加角色")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result add(@RequestBody Role role){
        roleService.add(role);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //删除角色
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        roleService.delete(id);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //根据用户id查询角色信息
//    @RequestMapping(value = "/findroles/{id}",method = RequestMethod.GET)
//    public Result findRolesByUserId(@PathVariable String id){
//        List<Role> roles = roleService.findRolesByUserId(id);
//        Result result = new Result(ResultCode.SUCCESS);
//        result.setData(roles);
//        return result;
//    }
    @RequestMapping(value = "/findroles/{id}",method = RequestMethod.GET)
    public List<Role> findRolesByUserId(@PathVariable String id){
        List<Role> roles = roleService.findRolesByUserId(id);
        return roles;
    }


}
