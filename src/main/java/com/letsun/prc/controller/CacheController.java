/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsun.prc.model.vo.CacheKeyValue;

import tcsyn.basic.model.ResponseModel;

/**
 * 
 * @author shiw
 * @date 2017年7月25日
 */
@Controller
@RequestMapping("cache")
public class CacheController extends AbstractPrcController {
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@RequestMapping("index")
	public String index(Model model, String key) {
		String system = super.getSessionSystem();
		String keys = this.getKeys(key, system);
		Set<String> set = this.redisTemplate.keys(keys);
		
		List<CacheKeyValue> list = new ArrayList<>();
		int i = 0;
		for (String str : set) {
			if (i >= 50) {
				break;
			}
			try {
				ValueOperations<String, String> opera = this.redisTemplate.opsForValue();
				String value = opera.get(str);
				list.add(new CacheKeyValue(str, value));
				i ++;
			} catch (Exception ignore) {}
		}
		model.addAttribute("list", list);
		return "cache/cache";
	}
	
	/**
	 * 清空缓存
	 * @param key
	 * @return
	 */
	@RequestMapping("remove")
	@ResponseBody
	public ResponseModel removeCache(String key) {
		this.redisTemplate.delete(key);
		return super.success("缓存已经清空");
	}

	/**
	 * 
	 * @param key
	 * @param system
	 * @return
	 */
	private String getKeys(String key, String system) {
		String keys = "*";
		if (StringUtils.isNotBlank(key)) {
			keys = "*" + key + "*";
		}
		if (StringUtils.isNotBlank(system)) {
			keys = system + keys;
		}
		return keys;
	}
}
