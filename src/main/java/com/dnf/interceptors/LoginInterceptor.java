package com.dnf.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dnf.entity.CustInfo;
import com.dnf.utils.CSRFToken;


/*
 * by lzl
 * 登录拦截器
 * 拦截所有url
 * 检查session中是否已登录
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
// 员工禁止跳转页面list
	private List<String> staffNotPass;
	
//	未登录时允许通过的路径
	private List<String> allowedpass;
	
//	登录后未填写个人资料时允许通过的路径
	private List<String> infoPass;
	
	private List<String> csrfList;

	public List<String> getCsrfList() {
		return csrfList;
	}

	public List<String> getInfoPass() {
		return infoPass;
	}

	public void setInfoPass(List<String> infoPass) {
		this.infoPass = infoPass;
	}

	public void setCsrfList(List<String> csrfList) {
		this.csrfList = csrfList;
	}

	public List<String> getAllowedpass() {
		return allowedpass;
	}

	public void setAllowedpass(List<String> allowedpass) {
		this.allowedpass = allowedpass;
	}
	

	public List<String> getStaffNotPass() {
		return staffNotPass;
	}

	public void setStaffNotPass(List<String> staffNotPass) {
		this.staffNotPass = staffNotPass;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		生成csrf校验码	
		String url = request.getRequestURL().toString();
		logger.info("请求的url:" + url);
		for(String temp : csrfList){
			if(url.endsWith(temp)){
//				请求的路径是页面路径，则生成或更新session中的csrf token
				request.setAttribute("_csrf", CSRFToken.setTokentoSession(request.getSession()));
				logger.info("生成的csrf校验码: " +  request.getAttribute("_csrf"));
			}
		}
		
		
//		用户未登录，校验请求url能否通过
		for(String temp:allowedpass) {
			if(url.endsWith(temp)){
				logger.info("校验路径尾部为: " + temp + "  校验通过");
				return true;
			}
		}

		
//		校验客户或员工是否已经登录
		Object cust = request.getSession().getAttribute("customer");
		Object staff = request.getSession().getAttribute("staff");
		if(cust != null){
			logger.info("用户已登录");
			CustInfo info = (CustInfo) request.getSession().getAttribute("custInfo");
			if(info == null){
				logger.info("用户尚未填写个人信息");
				if(url.endsWith("/DNFPro/info")){
					return true;
				}
				
				for(String temp:infoPass) {
					if(url.endsWith(temp)){
						logger.info("用户未填写个人信息: " + temp + "  校验通过");
						return true;
					}
				}
				
				response.sendRedirect("/DNFPro/info");
				return false;
			}else{
				
				if(url.endsWith("/DNFPro/info")){
//					用户已经填写信息，再去访问填写信息的页面，则不允许其访问
					response.sendRedirect("/DNFPro/main");
					return false;
				}else{
					return true;
				}
			}
		}else if(staff == null){
//			非法请求跳转到登录页面
			logger.error("用户未登录，非法请求，跳转到登录页面" );
			response.sendRedirect("/DNFPro/login");
			return false;
		}else{
			for(String temp: staffNotPass) {
				if(url.endsWith(temp)){
					logger.info("员工登录后禁止跳转页面: " + url);
					return false;
				}
			}
			return true;
		}
		
//		
////		非法请求跳转到登录页面
//		logger.error("用户未登录，非法请求，跳转到登录页面" );
//		response.sendRedirect("/DNFPro/login");
//		return false;
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
