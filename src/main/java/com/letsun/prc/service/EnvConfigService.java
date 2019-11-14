/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsun.cache.annotation.Cache;
import com.letsun.prc.constant.Constants;
import com.letsun.prc.mapper.EnvConfigMapper;
import com.letsun.prc.model.EnvConfig;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Service
public class EnvConfigService {
	
	@Autowired
	EnvConfigMapper envConfigMapper; 
	
	public List<EnvConfig> getEnvConfig(EnvConfig envConfig) {
		return this.envConfigMapper.select(envConfig);
	}
	
	@Cache(Constants.CacheKey.SYSTEM)
	public List<String> getEnvConfigSystem() {
		return this.envConfigMapper.getEnvConfigSystem();
	}
	
	public void saveEnvConfig(EnvConfig envConfig) {
		if (envConfig.getId() != null) {
			this.envConfigMapper.updateByPrimaryKeySelective(envConfig);
		} else {
			this.envConfigMapper.insert(envConfig);
		}
	}
	
	public void deleteEnvConfig(Integer id) {
		this.envConfigMapper.deleteByPrimaryKey(id);
	}
}
