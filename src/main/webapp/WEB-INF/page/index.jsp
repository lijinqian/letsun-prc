<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>登录 - 立信创源公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="inc/script-style.jsp" %>
        <link href="${rc.contextPath}/css/index.css" rel="stylesheet">
        <script type="text/javascript" src="${rc.contextPath}/js/module/index.js"></script>
        <script>
        	var path = '${rc.contextPath}';
        </script>
    </head>
    <body class="login-body container">
        <div class="container main-container">
        	<div class="row">
        		<div class="col-md-4 col-md-offset-4">
        			<form action="${rc.contextPath}/sign" class="form-horizontal form-signin" method="post">
        				<div class="form-group text-center">
        					<h2>登录 - 公共资源中心</h2>
        				</div>
        				<div class="form-group text-center">
        					<div class="col-md-6 col-xs-6 text-right">
        						<h4>账号登录</h4>
        					</div>
        					<div class="col-md-6 col-xs-6 text-left">
        						<h4>微信登录</h4>
        					</div>
        				</div>
	        			<div class="form-group form-group-lg has-feedback">
                            <input type="text" class="form-control input-lg" name="username" placeholder="请输入用户名" autofocus required="required">
                            <span class="icon-user form-control-feedback"></span>
	        			</div>
	        			<div class="form-group form-group-lg has-feedback">
                            <input type="password" class="form-control input-lg" name="password" placeholder="******" required="required">
                            <span class="icon-lock form-control-feedback"></span>
	        			</div>
	        			<div class="form-group">
	        				<button type="submit" class="btn btn-danger btn-lg btn-block">登 录</button>
	        			</div>
	        			<hr/>
	        		</form>
        		</div>
        	</div>
        	<div class="row text-center footer-div">
   				<p>© 2017 letsun.com.cn 京ICP备13017353号-3 京公网安备11010802012357号</p>
        	</div>
        </div>
    </body>
</html>