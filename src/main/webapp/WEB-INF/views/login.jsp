<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<hr>
${message}
<form action="${ctx}/login" method="post">
    <p><input type="text" name="username" value="" placeholder="用户名"></p>
    <p><input type="password" name="password" value="" placeholder="用户密码"></p>
    <p><button type="submit">登录</button></p>
</form>
<hr>
<a href="${ctx}/index">首页</a>
</body>
</html>
