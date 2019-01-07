package com.sune.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class MyUserDetailsService implements UserDetailsService {
    @Override

    /**
     * 根据登录请求的用户名称，查询数据库中保存的用户信息和角色列表信息
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 1.定义角色列表集合
        ArrayList<GrantedAuthority> authorityList = new ArrayList<>();

        // 2.模拟查询数据库\
        if ("user".equals(s)){
            // 普通用户，对应ROLE_USER角色
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
            //返回对象
            return new User("user","{noop}123456",authorityList);

        }
        if ("admin".equals(s)){
            // 管理员，对应ROLE_ADMIN角色
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            //返回对象
            return new User("admin","{noop}123456",authorityList);

        }
        //没有用户信息,返回null
        return null;
    }
}
