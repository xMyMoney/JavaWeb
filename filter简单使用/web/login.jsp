<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/4/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/loginServlet" method="post">
    <input type="text" placeholder="请输入用户名" name="username"><br>
    <input type="text" placeholder="请输入密码" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
