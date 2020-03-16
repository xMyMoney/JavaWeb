<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/3/11
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>注册</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .center-block{
            width: 490px;
            margin-top: 250px;
            background-color: #fffae3;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="center-block">
    <div class="form-horizontal">
        <form class="form-horizontal" action="/registerServlet" method="post">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="name" id="name" placeholder="name">
                </div>
            </div>
            <div class="form-group">
                <label for="age" class="col-sm-2 control-label">年龄</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="age" id="age" placeholder="age">
                </div>
            </div>
            <div class="form-group">
                <label for="gender" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="gender" id="gender" placeholder="gender">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">籍贯</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="address" id="address" placeholder="address">
                </div>
            </div>
            <div class="form-group">
                <label for="password1" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10 form-inline">
                    <input type="password" class="form-control" name="password1" id="password1" placeholder="password">
                </div>
            </div>
            <div class="form-group">
                <label for="password2" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10 form-inline">
                    <input type="password" class="form-control" name="password2" id="password2" placeholder="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-sm">注册</button>
                </div>
            </div>
        </form>
    </div>
    <div class="form-horizontal pull-right"><p>已有账户？立即<a href="login.jsp">登录</a></p></div>
</div>
</body>
</html>