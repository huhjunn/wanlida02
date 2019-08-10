package com.hujun.demo0621.shiro;

import com.hujun.demo0621.mapping.PermissionMapper;
import com.hujun.demo0621.mapping.RoleMapper;
import com.hujun.demo0621.mapping.UserMapper;
import com.hujun.demo0621.pojo.PePermission;
import com.hujun.demo0621.pojo.PeRole;
import com.hujun.demo0621.pojo.PeUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 构造授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取认证的用户数据
        PeUser user = (PeUser)principalCollection.getPrimaryPrincipal();
        //2.构造认证数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<PeRole> roles = roleMapper.findByUsername("2");
        for (PeRole role : roles) {
            //添加角色信息
            info.addRole(role.getName());
            for (PePermission permission:permissionMapper.findByRole("5")) {
                //添加权限信息
                info.addStringPermission(permission.getCode());
            }
        }
        return info;
    }
    /**
     * 认证方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取登录的upToken
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;
        //2.获取输入的用户名密码
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        //3.数据库查询用户
        PeUser user = userMapper.findByName(username);
        //4.用户存在并且密码匹配存储用户数据
        if(user != null && user.getPassword().equals(password)) {
            return new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        }else {
            //返回null会抛出异常，表明用户不存在或密码不匹配
            return null;
        }
    }
}
