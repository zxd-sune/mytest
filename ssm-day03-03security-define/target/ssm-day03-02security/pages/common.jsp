<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>普通页面</title>
    </head>
    <body>
        <h1>标题: ${title}</h1>
        <h1>消息 : ${message}</h1>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>欢迎: ${pageContext.request.userPrincipal.name}
                <a href="<c:url value='/logout'/>" > 退出</a></h2>
        </c:if>
    </body>
</html>