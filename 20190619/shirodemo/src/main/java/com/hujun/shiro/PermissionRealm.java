package com.hujun.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class PermissionRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("permissionRealm");
    }
    /**
     * 授权：授权的主要目的就是查询数据库获取用户的所有角色和权限信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1.从principals获取已认证用户的信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        /**
         * 正式系统：应该从数据库中根据用户名或者id查询
         *这里为了方便演示，手动构造
         */
        // 2.模拟从数据库中查询的用户所有权限
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:save");// 用户的创建
        permissions.add("user:update");// 商品添加权限
        //3.模拟从数据库中查询的用户所有角色
        List<String> roles = new ArrayList<String>();
        roles.add("role1");
        roles.add("role2");
        // 4.构造权限数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new
                SimpleAuthorizationInfo();
        // 5.将查询的权限数据保存到simpleAuthorizationInfo
        simpleAuthorizationInfo.addStringPermissions(permissions);
        // 6.将查询的角色数据保存到simpleAuthorizationInfo
        simpleAuthorizationInfo.addRoles(roles);
        return simpleAuthorizationInfo;
    }
    /**
     * 认证：认证的主要目的，比较用户输入的用户名密码是否和数据库中的一致
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取登录的upToken
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;
        //2.获取输入的用户名密码
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        /**
         * 3.验证用户名密码是否正确
         * 正式系统：应该从数据库中查询用户并比较密码是否一致
         *为了测试，只要输入的密码为123456则登录成功
         */
        if(!password.equals("123456")) {
            throw new RuntimeException("用户名或密码错误");//抛出异常表示认证失败
        }else{
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
                    password,
                    this.getName());
            return info;
        }
    }
}
