<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>${envConfig == null ? '新增' : '修改'}环境配置 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<form class="input-form form-horizontal" method="post" action="${rc.contextPath}/env_config/add">
						<input type="hidden" name="id" value="${envConfig.id }">
							<div class="form-group">
								<label class="col-sm-2 control-label">键：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control inline-input" name="key" value="${envConfig.key }" required="required">
								</div>
								<label class="col-sm-2 control-label">系统：</label>
								<div class="col-sm-3">
									<select class="form-control" name="system" required="required">
										<option value="">- 请选择 -</option>
										<c:forEach items="${systemList }" var="system">
											<option>${system }</option>	
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">值：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control inline-input" name="value" value="${envConfig.value }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-8">
									<textarea rows="3" class="form-control" name="remark">${envConfig.remark }</textarea>
								</div>
							</div>
							<div class="form-group text-center">
								<button type="submit" class="btn btn-default"><i class="icon-save"></i> 保存</button>
								<a href="${rc.contextPath}/env_config/index" class="btn btn-default back-btn"><i class="icon-reply"></i> 返回</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="${rc.contextPath}/js/module/env.config.input.js"></script>