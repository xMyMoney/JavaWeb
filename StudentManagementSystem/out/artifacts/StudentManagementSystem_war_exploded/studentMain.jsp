<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/3/11
  Time: 14:42
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
    <style>
        body {
            width: 100%;
            height: 100%;
            margin: 0;
            overflow: hidden;
            background-color: #FFFFFF;
            font-family: "Microsoft YaHei", sans-serif;
        }
        .pageSidebar{
            width: 240px;
            height:100%;
            padding-bottom: 30px;
            overflow: auto;
            background-color: #e3e3e3;
        }
        .splitter {
            width: 5px;
            height: 100%;
            bottom: 0;
            left: 240px;
            position: absolute;
            overflow: hidden;
            background-color: #fff;
        }
        .pageContent{
            height: 100%;
            min-width: 768px;
            left: 246px;
            top: 0;
            right: 0;
            z-index: 3;
            padding-bottom: 30px;
            position: absolute;
        }
        .pageContainer{
            bottom: 0;
            left:0;
            right: 0;
            top: 53px;
            overflow: auto;
            position: absolute;
        }
        .footer {
            width: 100%;
            height: 30px;
            line-height: 30px;
            margin-top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            position: absolute;
            z-index: 10;
            background-color:#DFDFDF;
        }
    </style>
    <script>

        window.onload = function () {
            document.getElementById("del").onclick = function () {
                if(confirm("您确定删除吗?")){
                    //location.href="/delStudentServlet?name="+${student.name};
                    alert(22222)
                }
            }

        }
    </script>
</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="#">个人中心</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation">
                    <a href="#">当前用户：<span class="badge">${student.name}</span></a>
                </li>
                <li>
                    <a href="/login.jsp">
                        <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- 中间主体内容部分 -->
<div class="pageContainer container">
    <!-- 左侧导航栏 -->
    <div class="pageSidebar">
        <ul class="nav nav-stacked nav-pills">
            <li role="presentation">
                <a href="/findStudentServlet?name=${student.name}" target="mainFrame" >信息总览</a>
            </li>
            <li role="presentation">
                <a href="/findStuToUpdateServlet?name=${student.name}" target="mainFrame">修改信息</a>
            </li>
            <li role="presentation">
                <a href="/findStuUpPassServlet?name=${student.name}" target="mainFrame">修改密码</a>
            </li>
            <li role="presentation">
                <a href="javascript:void(0);" id="del">注销帐号</a>
            </li>
        </ul>
    </div>
    <!-- 左侧导航和正文内容的分隔线 -->
    <div class="splitter"></div>
    <!-- 正文内容部分 -->
    <div class="pageContent">

        <iframe src="studentIndex.html" id="mainFrame" name="mainFrame" frameborder="0" width="100%"  height="100%" frameBorder="0"></iframe>
    </div>
</div>
<!-- 底部页脚部分 -->
<div class="footer">
    <p class="text-center">
        2020@zwx
    </p>
</div>
</body>
</html>
