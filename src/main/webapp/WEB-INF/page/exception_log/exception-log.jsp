<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>异常日志 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="row">
     			<nav class="navbar navbar-default">
	     			<div class="container">
	     				<form action="${rc.contextPath}/exception_log/index" class="form-inline" method="post">
						<div class="form-group">
							<label>错误码：</label> <input type="text" class="form-control" name="markCode" value="${param.markCode }">
						</div>
						<button type="submit" class="btn btn-default"><i class="icon-search"></i> 查询</button>
					</form>
					</div>
				</nav>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>错误码</th>
							<th>类</th>
							<th>方法</th>
							<th>系统</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exceptionLogList }" var="da" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${da.markCode }</td>
							<td>${da.handlerClass }</td>
							<td>${da.methodName }</td>
							<td>${da.system }</td>
							<td><fmt:formatDate value="${da.createDate }" type="both"/></td>
							<td><a href="${rc.contextPath}/exception_log/detail/${da.id}">详情</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>