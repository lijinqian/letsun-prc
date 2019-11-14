/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.letsun.prc.model.job.JobLog;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @author shiw
 * @date 2017年3月30日
 */
@Repository
public interface JobLogMapper extends Mapper<JobLog> {
	
	List<JobLog> getJobLog(@Param("code") String code);
}
