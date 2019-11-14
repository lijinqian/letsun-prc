/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsun.prc.mapper.PlatformUserMapper;
import com.letsun.prc.model.PlatformUser;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Service
public class PlatformUserService {
	
	@Autowired
	PlatformUserMapper platformUserMapper;
	
	public PlatformUser getPlatformUser(String username) {
		return this.platformUserMapper.selectOne(new PlatformUser(username));
	}
}
