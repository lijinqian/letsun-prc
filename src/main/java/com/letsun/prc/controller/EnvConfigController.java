/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsun.prc.model.EnvConfig;
import com.letsun.prc.service.EnvConfigService;

import tcsyn.basic.model.ResponseModel;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Controller
@RequestMapping("env_config")
public class EnvConfigController extends AbstractPrcController {
	
	@Autowired
	EnvConfigService envConfigService;
	
	@RequestMapping("index")
	public String index(Model model, EnvConfig envConfig) {
		if (StringUtils.isEmpty(envConfig.getKey())) {
			envConfig.setKey(null);
		}
		envConfig.setSystem(super.getSessionSystem());
		List<EnvConfig> envConfigList = this.envConfigService.getEnvConfig(envConfig);
		model.addAttribute("envConfigList", envConfigList);
		return "env_config/env-config";
	}
	
	@RequestMapping("input")
	public String input(Model model) {
		List<String> systemList = this.envConfigService.getEnvConfigSystem();
		model.addAttribute("systemList", systemList);
		return "env_config/env-config-input";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public ResponseModel edit(String field, String value, Integer id) throws Exception {
		EnvConfig envConfig = new EnvConfig();
		envConfig.setId(id);
		PropertyUtils.setProperty(envConfig, field, value);
		this.envConfigService.saveEnvConfig(envConfig);
		return super.success("修改成功");
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResponseModel add(EnvConfig envConfig) {
		this.envConfigService.saveEnvConfig(envConfig);
		return super.success("添加成功");
	}
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public ResponseModel delete(@PathVariable Integer id) {
		this.envConfigService.deleteEnvConfig(id);
		return super.success("删除成功");
	}
}
