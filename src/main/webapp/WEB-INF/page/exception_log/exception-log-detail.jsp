<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常日志详情 - 公共资源中心</title>
<%@include file="/WEB-INF/page/inc/script-style.jsp" %>
</head>
<body>
	<%@include file="/WEB-INF/page/inc/top.jsp" %>
	<div class="container">
		<div class="row">
			<div class="form-horizontal input-form">
				<div class="form-group">
					<label class="control-label col-sm-2">标记码：</label>
					<div class="col-sm-4">
						<p class="form-control-static">${log.markCode }</p>
					</div>
					<label class="control-label col-sm-2">创建时间：</label>
					<div class="col-sm-4">
						<p class="form-control-static"><fmt:formatDate value="${log.createDate }" type="both"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">url：</label>
					<div class="col-sm-10">
						<p class="form-control-static">${log.url }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">参数：</label>
					<div class="col-sm-10">
						<p class="form-control-static">${log.param }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">类：</label>
					<div class="col-sm-4">
						<p class="form-control-static">${log.handlerClass }</p>
					</div>
					<label class="control-label col-sm-2">方法：</label>
					<div class="col-sm-4">
						<p class="form-control-static">${log.methodName }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">异常堆栈：</label>
					<div class="col-sm-10">
						<pre class="form-control-static">${log.exception }</pre>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>