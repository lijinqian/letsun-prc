<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>任务管理 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="row">
     			<nav class="navbar navbar-default">
	     			<div class="container">
	     				<form action="${rc.contextPath}/job/index" class="form-inline" method="post">
							<div class="form-group">
								<label>标题：</label> <input type="text" class="form-control" name="title" value="${param.title }">
							</div>
							<button type="submit" class="btn btn-default"><i class="icon-search"></i> 查询</button>
							<div class="form-group navbar-right">
								<a class="btn btn-default" href="${rc.contextPath}/job/input"><i class="icon-plus-sign text-success"></i> 创建任务</a>
							</div>
						</form>
					</div>
				</nav>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>标题</th>
							<th>任务类型</th>
							<th>触发类型</th>
							<th>状态</th>
							<th>最近运行结果</th>
							<th>最近运行时间</th>
							<th>运行次数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobList }" var="job" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${job.title }</td>
							<td>
								<c:choose>
									<c:when test="${job.type == 1}">
										Class
									</c:when>
									<c:when test="${job.type == 2}">
										Remote
									</c:when>
									<c:when test="${job.type == 3}">
										SQL
									</c:when>
								</c:choose>
							</td>
							<td>${job.triggerType == 1 ? '简单类型' : 'cron类型' }</td>
							<td>
								<c:if test="${job.status == 1 }">
									<i class="icon-stop text-danger" data-toggle="tooltip" data-placement="top" title="已停止"></i>
								</c:if>
								<c:if test="${job.status == 2 }">
									<i class="icon-spinner icon-spin text-success" data-toggle="tooltip" data-placement="top" title="正在运行"></i>
								</c:if>
								<c:if test="${job.status == 3 }">
									<i class="icon-pause text-warning" data-toggle="tooltip" data-placement="top" title="休眠中"></i>
								</c:if>
							</td>
							<td>
								<c:choose>
									<c:when test="${job.recentResult eq 'Y' }">
										成功
									</c:when>
									<c:when test="${job.recentResult eq 'N' }">
										失败
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</td>
							<td><fmt:formatDate value="${job.recentDate }" type="both"/></td>
							<td>${job.totalCount }</td>
							<td>
								<a href="${rc.contextPath}/job/input?code=${job.code}">修改</a>
								<c:if test="${job.status == 1 }">
									<a href="javascript: void(0);" class="start-btn" data-key="${job.code }">启动</a>	
								</c:if>
								<c:if test="${job.status > 1 }">
									<a href="javascript: void(0);" class="stop-btn" data-key="${job.code }">停止</a>	
								</c:if>
								<a href="${rc.contextPath}/job/log?code=${job.code}" target="_blank">查看日志</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
<script src="${rc.contextPath}/js/module/job.js"></script>