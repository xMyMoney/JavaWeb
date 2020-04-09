<%--
  Created by IntelliJ IDEA.
  User: 00
  Date: 2020/4/9
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script>
      window.onload = function () {
          var checkname = document.getElementById("username");
          checkname.onblur = function () {
              if (checkname.value != "") {
                  //查询是否已存在该用户名
                  var xhr = new XMLHttpRequest();
                  xhr.open("get", "/findNameServlet?username=" + checkname.value, true);
                  xhr.send();
                  xhr.onreadystatechange = function () {
                      if (xhr.readyState == 4) {
                          var data = xhr.responseText;
                          //转换为 js 对象  原本是一个json字符串
                          data = JSON.parse(data);
                          //alert(data);
                          if (data.flag) {
                              document.getElementById("msg").style.color = "red";
                              document.getElementById("msg").innerHTML =  data.msg;
                          } else {
                              document.getElementById("msg").style.color = "green";
                              document.getElementById("msg").innerHTML =  data.msg;
                          }
                      }
                  }
              } else {
                  alert("空的啊")
              }
          }
      }
  </script>
</head>
<body>
<input type="text" placeholder="请输入用户名" id="username"><span id="msg"></span>
<br>
<input type="text" placeholder="请输入密码" id="password">
<br>
<button>注册</button>
</body>
</html>
