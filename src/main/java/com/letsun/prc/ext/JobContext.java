/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.letsun.prc.constant.JobTypeEnum;
import com.letsun.prc.mapper.JobMapper;
import com.letsun.prc.model.job.Job;

import tcsyn.basic.ext.SpringContextHolder;
import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
@Component
public class JobContext {
	
	final Logger logger = Logger.getLogger(getClass()); 
	
	final Map<String, Scheduler> map = new HashMap<>();
	
	@Autowired
	SpringContextHolder springContextHolder;
	
	@Autowired
	JobListener jobListener;
	
	@Autowired
	JobMapper jobMapper;
	
	public void start(Job job) throws Exception {
		String key = job.getCode();
		if (map.containsKey(key)) {
			Scheduler scheduler = map.get(key);
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
			scheduler = null;
		}
		Properties prop = new Properties();
		prop.setProperty("org.quartz.threadPool.threadCount", "1");
		prop.setProperty("org.quartz.scheduler.instanceName", "scheduler_" + key);
		StdSchedulerFactory factory = new StdSchedulerFactory(prop);
		Scheduler scheduler = factory.getScheduler();
		scheduler.getListenerManager().addJobListener(this.jobListener);
		JobDetail jobDetail = this.getJobDetail(job);
		
		Trigger trigger = this.getTrigger(job);
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		map.put(key, scheduler);
	}
	
	public void stop(String key) throws SchedulerException {
		if (map.containsKey(key)) {
			Scheduler scheduler = map.get(key);
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
			scheduler = null;
			map.remove(key);
		}
	}
	
	private JobDetail getJobDetail(Job job) {
		JobTypeEnum jobTypeEnum = JobTypeEnum.valueOf(job.getType());
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("content", job.getContent());
		jobDataMap.put("springContextHolder", springContextHolder);
		JobDetail jobDetail = JobBuilder.newJob(jobTypeEnum.getClazz()).withIdentity(job.getCode()).setJobData(jobDataMap).build();
		return jobDetail;
	}

	private Trigger getTrigger(Job job) {
		int trigger_type = job.getTriggerType();
		Trigger trigger = null;
		String triggerKey = "tri-" + job.getCode();
		if (trigger_type == 1) {
			Integer execute_count = job.getExecuteCount();
			
			SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(job.getExecuteInterval());
			if (execute_count == -1) {
				simpleScheduleBuilder.repeatForever();
			} else {
				simpleScheduleBuilder.withRepeatCount(job.getExecuteCount() - 1);
			}
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(simpleScheduleBuilder).build();
		} else if (trigger_type == 2) {
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpress())).build();
		}
		return trigger;
	}
	
	@PostConstruct
	public void init() {
		List<Job> jobList = getJob();
		try {
			for (Iterator<Job> iter = jobList.iterator(); iter.hasNext(); ) {
				this.start(iter.next());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private List<Job> getJob() {
		Example example = new Example(Job.class);
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		example.createCriteria().andIn("status", list);
		List<Job> jobList = this.jobMapper.selectByExample(example);
		return jobList;
	}
}
