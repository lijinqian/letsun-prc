<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>环境配置 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="row">
     			<nav class="navbar navbar-default">
	     			<div class="container">
	     				<form action="${rc.contextPath}/env_config/index" class="form-inline" method="post">
						<div class="form-group">
							<label>键：</label> <input type="text" class="form-control" name="key" value="${param.key }">
						</div>
						<button type="submit" class="btn btn-default"><i class="icon-search"></i> 查询</button>
						<div class="form-group navbar-right">
							<a class="btn btn-default" href="${rc.contextPath}/env_config/input"><i class="icon-plus-sign text-success"></i> 添加环境配置</a>
						</div>
					</form>
					</div>
				</nav>
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="col-sm-1">#</th>
							<th class="col-sm-2">键</th>
							<th>值 <i class="icon-question-sign text-primary" data-toggle="tooltip" data-placement="top" title="双击“键、值、备注”列单元格进入编辑状态"></i></th>
							<th class="col-sm-1">系统</th>
							<th class="col-sm-2">备注</th>
							<th class="col-sm-1">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${envConfigList }" var="en" varStatus="status">
						<tr data-id="${en.id}">
							<td>${status.index + 1 }</td>
							<td class="editable-td" data-field="key">${en.key }</td>
							<td class="editable-td" data-field="value">${en.value }</td>
							<td>${en.system }</td>
							<td class="editable-td" data-field="remark">${en.remark }</td>
							<td>
								<a href="javascript: void(0);" class="delete-link">删除</a>
							</td> 
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
<script src="${rc.contextPath}/js/module/env.config.js"></script>