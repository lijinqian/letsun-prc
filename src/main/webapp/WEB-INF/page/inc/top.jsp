<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid top-nav form-group">
	<div class="navbar-left system-navbar"></div>
	<div class="container top-menu">
		<a href="${rc.contextPath}/env_config/index" class="btn btn-link btn-lg">环境配置</a>
		<a href="${rc.contextPath}/exception_log/index" class="btn btn-link btn-lg">异常日志</a>
		<a href="${rc.contextPath}/cache/index" class="btn btn-link btn-lg">缓存管理</a>
		<a href="${rc.contextPath}/job/index" class="btn btn-link btn-lg">任务管理</a>
	</div>
</div>

<script>
	var path = '${rc.contextPath}';
	$(function(){
		$('.system-navbar').load('${rc.contextPath}/system/get');
	});
</script>
