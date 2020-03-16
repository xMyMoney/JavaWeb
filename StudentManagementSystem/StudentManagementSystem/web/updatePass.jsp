<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/3/16
  Time: 11:19
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
    <script>
        function checkOldPass() {
            var pass = document.getElementById("pass").value;
            var oldPass = document.getElementById("oldPass").value;
            if(pass != oldPass){
                alert("旧密码不正确");
            }
        }
        function checkNewPass() {
            var pass1 = document.getElementById("newPass1").value;
            var pass2 = document.getElementById("newPass2").value;
            if(pass1 != pass2){
                alert("新密码不一致");
            }
        }
    </script>
</head>
<body>
<div class="center-block container">
    <div class="form-horizontal">
        <form class="form-horizontal" action="/updatePassServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" id="id" value="${student.id}">
            <input type="hidden" name="pass" id="pass" value="${student.password}">
            <div class="form-group">
                <label for="oldPass" class="col-sm-2 control-label">旧密码</label>
                <div class="col-sm-10 form-inline">
                    <input type="text" class="form-control" name="oldPass" id="oldPass" onblur="checkOldPass()" placeholder="oldPass">
                </div>
            </div>
            <div class="form-group">
                <label for="newPass1" class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-10 form-inline">
                    <input type="password" class="form-control" name="newPass1" id="newPass1" placeholder="password">
                </div>
            </div>
            <div class="form-group">
                <label for="newPass2" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10 form-inline">
                    <input type="password" class="form-control" name="newPass2" id="newPass2" onblur="checkNewPass()" placeholder="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-sm">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
