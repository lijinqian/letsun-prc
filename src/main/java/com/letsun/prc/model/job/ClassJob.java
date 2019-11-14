/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import tcsyn.basic.ext.SpringContextHolder;
import tcsyn.basic.model.ResponseModel;

/**
 * 
 * @author shiw
 * @date 2017年3月28日
 */
@Component
public class ClassJob implements Job {
	
	final Logger logger = Logger.getLogger(getClass());
	
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ResponseModel responseModel = null;
		try {
			String content = context.getJobDetail().getJobDataMap().getString("content");
			SpringContextHolder springContextHolder = (SpringContextHolder) context.getJobDetail().getJobDataMap().get("springContextHolder");
			Class<? extends Executor> clazz = (Class<? extends Executor>) Class.forName(content.trim());
			Executor executor = springContextHolder.getBean(clazz);
			responseModel = executor.execute();
		} catch (Exception e) {
			responseModel = new ResponseModel();
			responseModel.setSuccess(false);
			responseModel.setMsg(ExceptionUtils.getStackTrace(e));	
		}
		context.setResult(responseModel);
	}
	
}
