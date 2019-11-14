/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.vo;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
public class CacheKeyValue {
	
	/**
	 * 
	 */
	public CacheKeyValue() {
		super();
	}

	/**
	 * @param key
	 * @param value
	 */
	public CacheKeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	private String key;
	
	private String value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
