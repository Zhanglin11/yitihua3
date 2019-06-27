<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="container">
<h2>首页</h2>

<ul>
    <li><a href="${ctx}/login">用户登录</a></li>
    <li><a href="${ctx}/user">用户管理</a></li>
</ul>
</div>
<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
