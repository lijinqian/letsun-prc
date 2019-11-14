/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import java.net.URI;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import tcsyn.basic.model.ResponseModel;
import tcsyn.basic.util.HttpClientUtil;
import tcsyn.basic.util.JsonUtil;

/**
 * 
 * @author shiw
 * @date 2017年3月28日
 */
@Component
public class RemoteJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ResponseModel responseModel = null;
		try {
			String url = (String) context.getJobDetail().getJobDataMap().get("content");
			String json = HttpClientUtil.httpPost(MediaType.APPLICATION_JSON_UTF8, new URI(url), null, 1000 * 60 * 10);
			responseModel = JsonUtil.fromJson(json, ResponseModel.class);
		} catch (Exception e) {
			responseModel.setSuccess(false);
			responseModel.setMsg(ExceptionUtils.getStackTrace(e));
		}
		context.setResult(responseModel);
	}

}
