package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.company.User;
import com.appointment.user.mapper.UserMapper;
import com.appointment.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        userService.add(user);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //删除用户
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        userService.delete(id);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //按id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        User user = userService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(user);
        return result;
    }
}
