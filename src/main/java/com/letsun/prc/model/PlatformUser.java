/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 平台用户
 * @author shiw
 * @date 2017年7月25日
 */
@Entity
@Table(name = "account")
public class PlatformUser {
	
	/**
	 * 
	 */
	public PlatformUser() {
		super();
	}

	/**
	 * @param username
	 */
	public PlatformUser(String username) {
		super();
		this.username = username;
	}

	public static final int STATUS_ENABLED = 1;
	
	public static final int STATUS_DISABLED = 0;
	
	private String accountId;
	
	private String username;
	
	private String password;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
