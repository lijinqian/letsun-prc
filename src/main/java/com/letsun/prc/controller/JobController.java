/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsun.prc.ext.JobContext;
import com.letsun.prc.model.job.Job;
import com.letsun.prc.model.job.JobLog;
import com.letsun.prc.service.JobService;

import tcsyn.basic.model.ResponseModel;

/**
 * 任务管理
 * @author shiw
 * @date 2017年7月25日
 */
@Controller
@RequestMapping("job")
public class JobController extends AbstractPrcController {
	
	@Autowired
	JobService jobService;
	
	@Autowired
	JobContext jobContext;
	
	@RequestMapping("index")
	public String index(Model model, Job job) {
		List<Job> jobList = this.jobService.getJob(job);
		model.addAttribute("jobList", jobList);
		return "job/job";
	}
	
	@RequestMapping("input")
	public String input(Model model, String code) {
		if (StringUtils.isNotBlank(code)) {
			Job job = this.jobService.getJob(code);
			model.addAttribute("job", job);
		}
		return "job/job-input";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public ResponseModel save(Job job) {
		this.jobService.saveJob(job);
		return super.success("保存成功");
	}
	
	@RequestMapping("start")
	@ResponseBody
	public ResponseModel start(String code) throws Exception {
		Job job = this.jobService.getJob(code);
		if (job != null) {
			job.setStatus(3);
			this.jobService.updateJob(job);
			this.jobContext.start(job);
		}
		return super.success("任务已经启动");
	}
	
	@RequestMapping("stop")
	@ResponseBody
	public ResponseModel stop(String code) throws Exception {
		this.jobContext.stop(code);
		Job job = new Job();
		job.setCode(code);
		job.setStatus(1);
		this.jobService.updateJob(job);
		return super.success("任务已经停止");
	}
	
	@RequestMapping("log")
	public String log(Model model, String code) {
		List<JobLog> jobLogList = this.jobService.getJobLog(code);
		model.addAttribute("jobLogList", jobLogList);
		return "job/job-log";
	}
}
