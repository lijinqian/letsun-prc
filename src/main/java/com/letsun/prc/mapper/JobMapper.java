/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.letsun.prc.model.job.Job;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @author shiw
 * @date 2017年3月28日
 */
@Repository
public interface JobMapper extends Mapper<Job> {
	
	List<Job> getJob(Job job);
}
