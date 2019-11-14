/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsun.prc.mapper.ExceptionLogMapper;

import tcsyn.basic.model.ExceptionLog;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Service
public class ExceptionLogService {
	
	@Autowired
	ExceptionLogMapper exceptionLogMapper;
	
	public List<ExceptionLog> getExceptionLog(ExceptionLog exceptionLog) {
		return this.exceptionLogMapper.getExceptionLog(exceptionLog);
	}
	
	public ExceptionLog getExceptionLog(Long id) {
		return this.exceptionLogMapper.selectByPrimaryKey(id);
	}
	
	public void saveExceptionLog(ExceptionLog exceptionLog) {
		this.exceptionLogMapper.insert(exceptionLog);
	}
}
