/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.letsun.prc.mapper.JobLogMapper;
import com.letsun.prc.mapper.JobMapper;
import com.letsun.prc.model.job.Job;
import com.letsun.prc.model.job.JobLog;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
@Service
public class JobService {
	
	@Resource
	JobMapper jobMapper;
	
	@Resource
	JobLogMapper jobLogMapper;
	
	public List<Job> getJob(Job job) {
		return this.jobMapper.getJob(job);
	}
	
	public void saveJob(Job job) {
		String code = job.getCode();
		if (StringUtils.isBlank(code)) {
			Date currentDate = new Date();
			job.setCode(Long.toString(currentDate.getTime(), 36));
			job.setCreatedDate(currentDate);
			job.setStatus(1);
			this.jobMapper.insert(job);
		} else {
			this.jobMapper.updateByPrimaryKeySelective(job);
		}
	}
	
	public void updateJob(Job job) {
		this.jobMapper.updateByPrimaryKeySelective(job);
	}
	
	public void updateJob(Job job, JobLog jobLog) {
		this.jobMapper.updateByPrimaryKeySelective(job);
		this.jobLogMapper.insert(jobLog);
	}
	
	public Job getJob(String code) {
		return this.jobMapper.selectByPrimaryKey(code);
	}
	
	public List<JobLog> getJobLog(String code) {
		return this.jobLogMapper.getJobLog(code);
	}
}
