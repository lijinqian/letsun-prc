/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsun.prc.service.ExceptionLogService;

import tcsyn.basic.model.ExceptionLog;

/**
 * 异常日志
 * @author shiw
 * @date 2017年7月25日
 */
@Controller
@RequestMapping("exception_log")
public class ExceptionLogController extends AbstractPrcController {
	
	@Autowired
	ExceptionLogService exceptionLogService;
	
	@RequestMapping("index")
	public String index(Model model, ExceptionLog exceptionLog) {
		exceptionLog.setSystem(super.getSessionSystem());
		List<ExceptionLog> exceptionLogList = this.exceptionLogService.getExceptionLog(exceptionLog);
		model.addAttribute("exceptionLogList", exceptionLogList);
		return "exception_log/exception-log";
	}
	
	/**
	 * 异常日志详情
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable Long id) {
		ExceptionLog exceptionLog = this.exceptionLogService.getExceptionLog(id);
		model.addAttribute("log", exceptionLog);
		return "exception_log/exception-log-detail";
	}
	
}
