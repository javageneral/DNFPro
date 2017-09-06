package com.dnf.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dnf.utils.Result;

public class PostCSRFInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(request.getMethod().toUpperCase().equals("POST")){
			String CSRFToken = (String) request.getAttribute("CSRFToken");
			if(CSRFToken != null && CSRFToken.equals(request.getSession().getAttribute("CSRF_TOKEN_FOR_SESSION_ATTR_NAME"))){
				return true;
			}else{
				logger.info("错误csrf码，非法请求");
				Result result = new Result(false, "你的操作过于频繁，请刷新页面");
				try{
					response.sendError(400, result.toString());
				}catch(Exception e){
					logger.info(e.getMessage());
				}
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	

}
