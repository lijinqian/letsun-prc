/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import com.letsun.prc.constant.Constants;

import tcsyn.basic.controller.AbstractController;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
public abstract class AbstractPrcController extends AbstractController {
	
	public String getSessionSystem() {
		return (String) super.getSession().getAttribute(Constants.SessionKey.SYSTEM);
	}
}
