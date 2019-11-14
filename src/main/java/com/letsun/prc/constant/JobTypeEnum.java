/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.constant;

import org.quartz.Job;

import com.letsun.prc.model.job.ClassJob;
import com.letsun.prc.model.job.RemoteJob;
import com.letsun.prc.model.job.SqlJob;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
public enum JobTypeEnum {
	
	CLASS_JOB(1, ClassJob.class),
	REMOTE_JOB(2, RemoteJob.class),
	SQL_JOB(3, SqlJob.class);
	
	private int type;
	
	private Class<? extends Job> clazz;
	
	private JobTypeEnum(int type, Class<? extends Job> clazz) {
		this.type = type;
		this.clazz = clazz;
	}
	
	public static JobTypeEnum valueOf(int type) {
		for (JobTypeEnum jobType : JobTypeEnum.values()) {
			if (jobType.getType() == type) {
				return jobType;
			}
		}
		return null;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the clazz
	 */
	public Class<? extends Job> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<? extends Job> clazz) {
		this.clazz = clazz;
	}
}
