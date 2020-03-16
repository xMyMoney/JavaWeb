<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/3/15
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title></title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
    <tbody>
    <tr>
        <th>姓名</th>
        <td>${student.name}</td>

    </tr>
    <tr>
        <th>年龄</th>
        <td>${student.age}</td>

    </tr>
    <tr>
        <th>性别</th>
        <td>${student.gender}</td>
    </tr>
    <tr>
        <th>籍贯</th>
        <td>${student.address}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
