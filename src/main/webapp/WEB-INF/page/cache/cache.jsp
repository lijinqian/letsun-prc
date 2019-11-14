<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>缓存管理 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
        <script type="text/javascript" src="${rc.contextPath}/js/module/cache.js"></script>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="row">
     			<nav class="navbar navbar-default">
	     			<div class="container">
	     				<form action="${rc.contextPath}/cache/index" class="form-inline" method="post">
						<div class="form-group">
							<label>键：</label> <input type="text" class="form-control" name="key" value="${param.key }">
						</div>
						<button type="submit" class="btn btn-default"><i class="icon-search"></i> 查询</button>
					</form>
					</div>
				</nav>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th class="col-sm-2">键</th>
							<th>值</th>
							<th class="col-sm-1">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="ca" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${ca.key }</td>
							<td>${ca.value }</td>
							<td>
								<a href="javascript: void(0);" class="remove-link" data-key="${ca.key }">清空缓存</a>
							</td> 
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>