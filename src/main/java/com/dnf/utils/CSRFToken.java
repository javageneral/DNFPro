package com.dnf.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CSRFToken {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CSRFToken.class);
	
	private CSRFToken() {

	};

	static final String CSRF_PARAM_NAME = "CSRFToken";

	// 生成一个csrf token存放到session中
	public static String setTokentoSession(HttpSession session) {
		String token = null;
		synchronized (session) {
			token = UUID.randomUUID().toString();
			session.setAttribute(CSRF_PARAM_NAME, token);
		}
		return token;
	}

	private static boolean isHaveToken(HttpServletRequest request) {
		Object token = request.getParameter(CSRF_PARAM_NAME);
		if (token != null) {
			return true;
		}
		return false;
	}
	
	public static boolean checkToken(HttpServletRequest request){
		if(!isHaveToken(request)){
			logger.info("非法请求,request中没有csrf码");
			return false;
		}
		String token = String.valueOf(request.getParameter(CSRF_PARAM_NAME));
		logger.info("request:" + token + "  session:" + request.getSession().getAttribute(CSRF_PARAM_NAME));
		if(token.equals(request.getSession().getAttribute(CSRF_PARAM_NAME))){
			updateToken(request.getSession());
			return true;
		}else{
			logger.info("csrf码不一致，请刷新页面");
			return false;
		}
	}
	
	public static void updateToken(HttpSession session){
		setTokentoSession(session);
		logger.info("更新token："  + session.getAttribute(CSRF_PARAM_NAME));
	}
}
