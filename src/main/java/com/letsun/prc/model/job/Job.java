/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author shiw
 * @date 2017年3月3日
 */
@Entity
@Table(name = "sys_job")
public class Job {
	
	@Id
	private String code;
	
	private String title;
	
	private String remark;
	
	private Integer triggerType;
	
	private Integer executeInterval;
	
	private Integer executeCount;
	
	private String cronExpress;
	
	private Integer type;
	
	private String content;

	private Integer status;
	
	private Date createdDate;
	
	private String recentResult;
	
	private Date recentDate;
	
	@Transient
	private Integer totalCount;

	@Transient
	public String getStatusLabel() {
		if (this.getStatus() == 1) {
			return "停止";
		} else if (this.getStatus() == 2) {
			return "运行中";
		} else if (this.getStatus() == 3) {
			return "休眠";
		}
		return "";
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the triggerType
	 */
	public Integer getTriggerType() {
		return triggerType;
	}

	/**
	 * @param triggerType the triggerType to set
	 */
	public void setTriggerType(Integer triggerType) {
		this.triggerType = triggerType;
	}

	/**
	 * @return the executeInterval
	 */
	public Integer getExecuteInterval() {
		return executeInterval;
	}

	/**
	 * @param executeInterval the executeInterval to set
	 */
	public void setExecuteInterval(Integer executeInterval) {
		this.executeInterval = executeInterval;
	}

	/**
	 * @return the executeCount
	 */
	public Integer getExecuteCount() {
		return executeCount;
	}

	/**
	 * @param executeCount the executeCount to set
	 */
	public void setExecuteCount(Integer executeCount) {
		this.executeCount = executeCount;
	}

	/**
	 * @return the cronExpress
	 */
	public String getCronExpress() {
		return cronExpress;
	}

	/**
	 * @param cronExpress the cronExpress to set
	 */
	public void setCronExpress(String cronExpress) {
		this.cronExpress = cronExpress;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the recentResult
	 */
	public String getRecentResult() {
		return recentResult;
	}

	/**
	 * @param recentResult the recentResult to set
	 */
	public void setRecentResult(String recentResult) {
		this.recentResult = recentResult;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the recentDate
	 */
	public Date getRecentDate() {
		return recentDate;
	}

	/**
	 * @param recentDate the recentDate to set
	 */
	public void setRecentDate(Date recentDate) {
		this.recentDate = recentDate;
	}

}
