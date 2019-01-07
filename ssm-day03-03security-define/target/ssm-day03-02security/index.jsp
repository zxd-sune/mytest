<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>spring security学习首页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/common">去【普通页面】试试！</a><hr/>
<a href="${pageContext.request.contextPath}/welcome">去【欢迎页面】试试！</a><hr/>
<a href="${pageContext.request.contextPath}/admin">去【管理页面】试试！</a>
</body>
</html>