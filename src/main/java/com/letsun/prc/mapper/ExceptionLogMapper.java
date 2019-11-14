/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import tcsyn.basic.model.ExceptionLog;
import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Repository
public interface ExceptionLogMapper extends Mapper<ExceptionLog> {
	
	List<ExceptionLog> getExceptionLog(ExceptionLog exceptionLog);
	
}
