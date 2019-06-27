<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
用户${user.userName}登录成功！
<p>${user.name}</p>

<p><a href="${ctx}/login">返回登录</a></p>
</body>
</html>
