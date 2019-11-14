/*
 * Copyright (c) 2017, Letsun and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.letsun.prc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.letsun.prc.constant.Constants;

/**
 * 
 * @author shiw
 * @date 2017年7月3日
 */
public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object object = (Object) session.getAttribute(Constants.SessionKey.USER);
		if (object == null) {
			response.sendRedirect(session.getServletContext().getContextPath() + "/");
			return false;
		} else {
			return super.preHandle(request, response, handler);
		}
	}

}
