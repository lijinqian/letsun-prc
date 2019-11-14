<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group">
	<a class="btn btn-link btn-lg dropdown-toggle" data-toggle="dropdown">
		${sessionScope.current_system == null ? '切换系统' : sessionScope.current_system} <span class="caret"></span>
	</a>
	<ul class="dropdown-menu" role="menu">
		<c:forEach items="${systemList }" var="system">
			<li><a href="${rc.contextPath}/main?system=${system}">${system }</a></li>	
		</c:forEach>
	</ul>
</div>
