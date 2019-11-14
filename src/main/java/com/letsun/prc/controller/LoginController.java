/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsun.prc.constant.Constants;
import com.letsun.prc.model.PlatformUser;
import com.letsun.prc.service.EnvConfigService;
import com.letsun.prc.service.PlatformUserService;

import tcsyn.basic.model.ResponseModel;
import tcsyn.basic.util.TextUtil;

/**
 * 
 * @author shiw
 * @date 2017年6月30日
 */
@Controller
@RequestMapping
public class LoginController extends AbstractPrcController {
	
	final  Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	PlatformUserService platformUserService;
	
	@Autowired
	EnvConfigService envConfigService;
	
	@RequestMapping("index")
	public String index() {
		Object object = super.getSession().getAttribute(Constants.SessionKey.USER);
		if (object != null) {
			return "main";
		}
		return "index";
	}
	
	@RequestMapping("sign")
	@ResponseBody
	public ResponseModel sign(String username, String password) {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return super.fail("用户名、密码不能为空");
		}
		PlatformUser platformUser = this.platformUserService.getPlatformUser(username);
		if (platformUser == null) {
			return super.fail("用户名不存在");
		}
		if (!StringUtils.equals(TextUtil.md5(password), platformUser.getPassword())) {
			return super.fail("密码错误");
		}
		super.getSession().setAttribute(Constants.SessionKey.USER, platformUser);
		return super.success();
	}
	
	@RequestMapping("main")
	public String main(Model model, String system) {
		if (StringUtils.isNotBlank(system)) {
			super.getSession().setAttribute(Constants.SessionKey.SYSTEM, system);
		}
		return "main";
	}
	
	@RequestMapping("system/get")
	public String getSystem(Model model) {
		List<String> systemList = this.envConfigService.getEnvConfigSystem();
		model.addAttribute("systemList", systemList);
		return "inc/system";
	}
}
