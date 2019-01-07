<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>用户登录</title>
    </head>
    <body>
        <form action="/login" method="POST">
            <table>
                <tr>
                    <td>用户名称:</td>
                    <td><input type='text' name='username'></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type='password' name='password' /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                           value="登录" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>