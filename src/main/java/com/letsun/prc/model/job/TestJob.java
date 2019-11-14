/*
 * Copyright (c) 2016, Feiliks and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.model.job;

import org.springframework.stereotype.Component;

import tcsyn.basic.model.ResponseModel;

/**
 * 
 * @author shiw
 * @date 2017年3月29日
 */
@Component
public class TestJob implements Executor {

	@Override
	public ResponseModel execute() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseModel();
	}

}
