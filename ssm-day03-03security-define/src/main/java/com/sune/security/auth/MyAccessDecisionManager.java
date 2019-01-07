package com.sune.security.auth;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.security.Security;
import java.util.Collection;
import java.util.Iterator;

/**
 * 访问决策器,决定某个用户具有的角色,是否有足够的权限去访问某个资源
 */
public class MyAccessDecisionManager implements AccessDecisionManager{
    /**
     *   /**
     * 校验用户的权限是否足够，是否有权限
     * 参数：
     *      authentication：当前登录的用户认证对象（包含有用户的角色列表）
     *      o：当前请求的对象（包含有请求的url）
     *      collection：当前请求的url，对应的角色集合
     */

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //获取权限集合数据
        Iterator<ConfigAttribute> iter = collection.iterator();
        while(iter.hasNext()){
            ConfigAttribute ca = iter.next();
            String needRole = ((SecurityConfig)ca).getAttribute();
            System.out.println("需要角色"+ needRole);

            /**
             * 比较当前登录用户的角色列表中，是否与当前请求的资源（url）有相同的角色
             * 1.有，则说明有权限访问
             * 2.没有，说明没有权限访问
             */
            for (GrantedAuthority ga:authentication.getAuthorities()
                 ) {
                if (needRole.equals(ga.getAuthority())){
                    return;
                }
            }
        }
        //抛出没有权限的异常
        throw new AccessDeniedException("no right");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
