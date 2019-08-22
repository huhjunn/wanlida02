package com.appointment.user.realm;

import com.appointment.user.Permission;
import com.appointment.user.Role;
import com.appointment.user.User;
import com.appointment.user.service.PermissionService;
import com.appointment.user.service.RoleService;
import com.appointment.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    public void setName(String name) {
        super.setName("userRealm");
    }

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取已认证的用户数据
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.根据用户数据获取用户的权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = roleService.findRolesByUserId(user.getId());
        for (Role role: roles) {
            info.addRole(role.getName());
            for(Permission permission : permissionService.findPermissionsByRoleId(role.getId())){
                info.addStringPermission(permission.getCode());
            }
        }
        System.out.println("执行授权方法");
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取登录的用户名、密码（token）
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String phone = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        //2.根据用户名查询数据库
        User user = userService.findByPhone(phone);
        System.out.println("执行认证方法");
        //3.判断用户是否存在或密码是否一致
        if(user != null && user.getPassword().equals(password)){
            //4.一直返回安全数据
            //参数分别为  安全数据，密码，realm名
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,this.getName());
            return info;
        }else {
            //5.不一致，返回null，抛异常
            return null;
        }
    }
}
