<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/3/15
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>学生</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="center-block container">
    <div class="form-horizontal">
        <form class="form-horizontal" action="/updateServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${student.id}">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="name" id="name" value="${student.name}">
                </div>
            </div>
            <div class="form-group">
                <label for="age" class="col-sm-2 control-label">年龄</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="age" id="age" value="${student.age}">
                </div>
            </div>
            <div class="form-group">
                <label for="gender" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="gender" id="gender" value="${student.gender}">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">籍贯</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="address" id="address" value="${student.address}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-sm">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
