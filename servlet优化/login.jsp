<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/studentServlet?method=login" method="post">
	<input type="submit" value="登录">
</form>

<a href="${pageContext.request.contextPath}/studentServlet?method=loginOut">退出</a>

</body>
</html>