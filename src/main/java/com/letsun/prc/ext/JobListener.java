/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.ext;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.letsun.prc.model.job.Job;
import com.letsun.prc.model.job.JobLog;
import com.letsun.prc.service.JobService;

import tcsyn.basic.model.ResponseModel;
import tcsyn.basic.util.JsonUtil;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
@Component
public class JobListener implements org.quartz.JobListener {
	
	final Logger logger = Logger.getLogger(getClass());
	
	@Resource
	JobService jobService;
	
	@Override
	public String getName() {
		return "JobListener";
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext arg0) {
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		try {
			Date currentDate = new Date();
			String code = context.getJobDetail().getKey().getName();
			Job job = new Job();
			job.setCode(code);
			job.setRecentDate(currentDate);
			job.setStatus(2);
			jobService.updateJob(job);
			context.put("start_date", currentDate);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException arg1) {
		try {
			String code = context.getJobDetail().getKey().getName();
			ResponseModel response = (ResponseModel) context.getResult();
			String result = "N";
			if (response != null && response.isSuccess()) {
				result = "Y";
			}
			Date currentDate = new Date();
			Date start_date = (Date) context.get("start_date");
			Job job = new Job();
			job.setCode(code);
			job.setStatus(3);
			job.setRecentResult(result);
			
			JobLog jobLog = new JobLog();
			jobLog.setSuccess(result);
			jobLog.setStartDate(start_date);
			jobLog.setJobCode(code);
			Integer cost_time = (int) (currentDate.getTime() - start_date.getTime());
			jobLog.setCostTime(cost_time);
			jobLog.setFinishedDate(currentDate);
			jobLog.setOutputInfo(JsonUtil.toJson(response));
			jobService.updateJob(job, jobLog);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
}
