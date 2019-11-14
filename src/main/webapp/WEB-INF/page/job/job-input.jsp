<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>${job == null ? '新增' : '修改'}任务 - 公共资源中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <%@include file="/WEB-INF/page/inc/script-style.jsp" %>
    </head>
    <body>
    	<%@include file="/WEB-INF/page/inc/top.jsp" %>
    	<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<form class="input-form form-horizontal" method="post" action="${rc.contextPath}/job/save">
						<input type="hidden" name="code" value="${job.code }">
							<div class="form-group">
								<label class="col-sm-2 control-label">任务标题：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control inline-input" name="title" value="${job.title }">
								</div>
								<label class="col-sm-2 control-label">任务类型：</label>
								<div class="col-sm-3">
									<select class="form-control" name="type">
										<option value="1">Class</option>
										<option value="2">Remote</option>
										<option value="3">SQL</option>
									</select> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">任务内容：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control inline-input" name="content" value="${job.content }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">触发类型：</label>
								<div class="col-sm-3">
									<select class="form-control" name="triggerType">
										<option value="1">简单类型</option>
										<option value="2">cron类型</option>
									</select> 
								</div>
							</div>
							<div class="form-group tt tt1">
								<label class="col-sm-2 control-label">执行间隔：</label>
								<div class="col-sm-3">
									<div class="input-group">
										<input type="text" class="form-control inline-input" name="executeInterval" value="${job.executeInterval }">
							            <span class="input-group-addon">秒</span>
									</div>
								</div>
								<label class="col-sm-2 control-label">执行次数：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control inline-input" name="executeCount" value="${job.executeCount }" placeholder="-1表示一直执行">
								</div>
							</div>
							<div class="form-group tt tt2">
								<label class="col-sm-2 control-label">Cron表达式：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control inline-input" name="cronExpress" value="${job.cronExpress }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-8">
									<textarea rows="3" class="form-control" name="remark">${job.remark }</textarea>
								</div>
							</div>
							<div class="form-group text-center">
								<button type="submit" class="btn btn-default"><i class="icon-save"></i> 保存</button>
								<a href="${rc.contextPath}/job/index" class="btn btn-default back-btn"><i class="icon-reply"></i> 返回</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="${rc.contextPath}/js/module/job.input.js"></script>
<c:if test="${job != null }">
	<script>
	$(function(){
		$('[name="triggerType"]').val('${job.triggerType }').change();
		$('[name="type"]').val('${job.type }');
	});
	</script>
</c:if>