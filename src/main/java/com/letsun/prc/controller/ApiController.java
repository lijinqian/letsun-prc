/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsun.prc.service.ExceptionLogService;

import tcsyn.basic.model.ExceptionLog;
import tcsyn.basic.model.ResponseModel;
import tcsyn.basic.util.JsonUtil;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Controller
@RequestMapping("api")
public class ApiController extends AbstractPrcController {
	
	@Autowired
	ExceptionLogService exceptionLogService; 
	
	@RequestMapping("exception_log/save")
	@ResponseBody
	public ResponseModel saveExceptionLog(String data) throws Exception {
		if (StringUtils.isNotBlank(data)) {
			ExceptionLog exceptionLog = JsonUtil.fromJson(data, ExceptionLog.class);
			this.exceptionLogService.saveExceptionLog(exceptionLog);
			return super.success();
		}
		return super.fail("参数错误");
	}
}
