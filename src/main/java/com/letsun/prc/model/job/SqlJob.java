/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * 
 * @author shiw
 * @date 2017年3月28日
 */
@Component
public class SqlJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

	}

}
