package com.sune.security.auth;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 作用：资源数据定义，定义某一资源可以被哪些角色访问。建立资源url与角色的对应关系。
 */
public class MyInvocationSecurityMetadataSource
implements FilterInvocationSecurityMetadataSource {

    /**
     * 权限集合
     */
    private static Map<String,Collection<ConfigAttribute>> resourceMap = null;

    /**
     * 获取请求URL的所有权限
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        //创建权限集合
       resourceMap =  new HashMap<String,Collection<ConfigAttribute>>();
        /**
         * WELCOME**资源
         *          可以被普通用户和管理员访问
         */
        ArrayList<ConfigAttribute> atts = new ArrayList<>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        ConfigAttribute ca1 = new SecurityConfig("ROLE_ADMIN");
        atts.add(ca);
        atts.add(ca1);

        resourceMap.put("/welcome",atts);

        /**
         * admin**
         *      资源只能被管理员访问
         */
        ArrayList<ConfigAttribute> atts1 = new ArrayList<>();
        atts1.add(ca1);

        resourceMap.put("/admin**",atts1);

        /**
         * 处理权限集合
         */
        //将参数转为url

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
