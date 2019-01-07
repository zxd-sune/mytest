package com.sune.security.auth;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * z自定义授权过滤器
 *  1.需要继承AbstractSecurityInterceptor
 *  2.需要实现Filter
 */

public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    //资源数据引用(用于获取当前数据请求资源,对应的所有资源权限)
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤器的方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * FilterInvocation：存储doFilter方法的request、response、filterChain对象
         * 细节：这里面最主要的是有当前请求的url
         */
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        /**
         * 方法：beforeInvocation
         *      1.调用MyInvocationSecurityMetadataSource的方法：getAttributes(Object object)获取fi对应的所有权限
         *      2.再调用MyAccessDecisionManager的方法：decide()校验用户的权限是否足够
         */

        InterceptorStatusToken token = super.beforeInvocation(fi);

        try {
            fi.getChain().doFilter(fi.getRequest(),fi.getResponse());
        } finally {
            super.afterInvocation(token,null);
        }
    }

    //销毁方法
    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }
    /**
     *=========================getter/setter======================
     */
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return securityMetadataSource;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return  this.securityMetadataSource;
    }
}
