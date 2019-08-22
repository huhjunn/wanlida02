package com.appointment.user.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.common.handler.BaseExceptionHandler;
import com.appointment.user.User;
import com.appointment.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
@Api(value = "用户管理接口",description = "用户增删改查")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @ApiOperation("添加用户")
    @RequestMapping(value = "/user/",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        userService.add(user);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //删除用户
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        userService.delete(id);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //按id查询
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        User user = userService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(user);
        return result;
    }

    //根据手机号查询用户
//    @RequiresPermissions("USER_FIND")
//    @RequestMapping(value = "/user/findbyphone/{phone}",method = RequestMethod.GET)
//    public User findByPhone(@PathVariable String phone){
//            User user = userService.findByPhone(phone);
//            return user;
//    }
    @RequiresPermissions("USER_FIND")
    @RequestMapping(value = "/user/findbyphone/{phone}",method = RequestMethod.GET)
    public Result findByPhone(@PathVariable String phone){
            User user = userService.findByPhone(phone);
            Result result = new Result(ResultCode.SUCCESS);
            result.setData(user);
            return result;
    }

    //用户登录
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap) {
        String phone = loginMap.get("phone");
        String password = loginMap.get("password");
        password = new Md5Hash(password,phone,3).toString();

        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken uptoken = new UsernamePasswordToken(phone,password);
            subject.login(uptoken);
            return new Result(ResultCode.SUCCESS);
        }catch (Exception e) {
            return new Result(ResultCode.PHONEORPASSWORDERROR);
        }
    }

}
