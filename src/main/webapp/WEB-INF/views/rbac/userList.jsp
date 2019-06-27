<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/static/commons.js"></script>
    <script>
        $(document).ready(function () {
           $("#btn_bkCreate").bind("click",function () {
               window.location.href="${ctx}/user/create";
           });
        });
    </script>
</head>
<body>
<div class="container">
    <tags:nav/>
    <div class="page-header">
        <h3>用户管理</h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button type="button" class="btn btn-default" id="btn_bkCreate">创建</button>
            <button type="button" class="btn btn-danger" id="btn_bkDelete">批量删除</button>
        </div>
        <div class="col-md-12">
            <form class="form-search" method="post" action="#">
                <label>名称：</label> <input type="text" name="s_LIKE_name" class="input-medium" value="${param.s_LIKE_name}">
                <button type="submit" class="btn btn-danger"><i class="icon-search"></i> Search</button>
            </form>
        </div>
    </div>
    <table id="contentTable" class="table table-striped table-hover">
        <thead><tr>
            <th><input type="checkbox" id="chkAll"></th>
            <th>序号</th>
            <th>字典名称</th>
            <th>属性编码</th>
            <th>属性名称</th>
            <th>属性状态</th>
            <th>管理</th></tr></thead>
        <tbody>
        <c:forEach items="${users.content}" var="user" varStatus="idxStatus">
            <tr>
                <td><input type="checkbox" name="chkIds" value="${dict.id}"></td>
                <td>${idxStatus.index+1}</td>
                <td>${dict.type}
                </td>
                <td>${dict.code}</td>
                <td>${dict.name}</td>
                <td>${dict.status.desc}</td>
                <td> <a href="${ctx}/dict/update/${dict.id}">编辑</a>  |   <a href="#" class="cla_delete" id="${dict.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <tags:pagination page="${users}" paginationSize="${PAGE_SIZE}"/>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
