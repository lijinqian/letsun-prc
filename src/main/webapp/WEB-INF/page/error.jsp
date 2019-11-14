<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>抱歉 - 椰岛活动管理后台</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="inc/script-style.jsp" %>
    </head>
    <body>
		<div class="jumbotron">
			<div class="container">
				<h1>抱歉，服务器运行中遇到了一个错误</h1>
				<p>错误码：${markCode }</p>
				<p><a class="btn btn-default btn-lg" href="javascript: history.back(-1);" role="button"><i class="icon-reply"></i> 返回</a></p>
			</div>
		</div>
	</body>
</html>