/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import tcsyn.basic.model.ResponseModel;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
public interface Executor {
	
	ResponseModel execute() throws Exception;
}
