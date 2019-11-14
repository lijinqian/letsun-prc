<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>任务日志 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>开始时间</th>
							<th>完成时间</th>
							<th>运行结果</th>
							<th>耗时（毫秒）</th>
							<th>输出信息</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobLogList }" var="log" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td><fmt:formatDate value="${log.startDate }" type="both"/></td>
							<td><fmt:formatDate value="${log.finishedDate }" type="both"/></td>
							<td>
								<c:if test="${log.success eq 'Y' }">
									<i class="icon-ok-circle text-success"></i>
								</c:if>
								<c:if test="${log.success eq 'N' }">
									<i class="icon-remove-sign text-danger"></i>
								</c:if>
							</td>
							<td>${log.costTime }</td>
							<td>${log.outputInfo }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
