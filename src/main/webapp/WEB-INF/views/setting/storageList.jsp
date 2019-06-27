<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>资源存储路径列表</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/static/commons.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn_bkCreate").click(function(){
                window.location.href="${ctx}/storage/create";
            }) ;
            $(".cla_delete").bind("click",function () {
                if (confirm("确定要删除吗？")){
                    var id=$(this).attr("id");
                    window.location.href="${ctx}/storage/delete/"+id;
                }
            });
            checkAllFunction("#chkAll","chkIds");
        });
    </script>
</head>
<body>
<div class="container">
    <tags:nav/>
    <div class="page-header">
        <h3>资源存储路径管理</h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button type="button" class="btn btn-default" id="btn_bkCreate">创建</button>
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
            <th>路径地址</th>
            <th>路径描述</th>
            <th>管理</th></tr></thead>
        <tbody>
        <c:forEach items="${storages.content}" var="storage" varStatus="idxStatus">
            <tr>
                <td><input type="checkbox" name="chkIds" value="${storage.id}"></td>
                <td>${idxStatus.index+1}</td>
                <td>${storage.content}</td>
                <td>${storage.title}</td>
                <td> <a href="${ctx}/storage/update/${storage.id}">编辑</a>  |   <a href="#" class="cla_delete" id="${storage.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <tags:pagination page="${storages}" paginationSize="${PAGE_SIZE}"/>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
