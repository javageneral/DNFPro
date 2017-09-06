package com.dnf.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnf.dto.CustMsg;
import com.dnf.entity.CustInfo;
import com.dnf.entity.Customer;
import com.dnf.service.CustomerService;
import com.dnf.utils.Result;
import com.dnf.utils.VerifyCodeUtils;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService custService;
	
	@RequestMapping(value="/login.action", method=RequestMethod.POST)
	@ResponseBody
	public Result login(HttpServletRequest request){
//		校验token
//		if(!CSRFToken.checkToken(request)){
//			return new Result(false, "您的操作过于频繁，请刷新页面");
//		}
	
		//校验手机号码格式
		String phoneNum = (String) request.getParameter("phone_num");
		String password = (String) request.getParameter("password");
		Result result = custService.custLogin(phoneNum, password);
		if(result.isSuccess()){
			Map<String, Object> map = (Map<String, Object>) result.getData();
			if(map.get("customer") != null){
				request.getSession().setAttribute("customer", (Customer)map.get("customer"));
			}
			if(map.get("custInfo") != null){
				request.getSession().setAttribute("custInfo", (CustInfo)map.get("custInfo"));
			}
			if(map.get("customerMsg") != null){
				request.getSession().setAttribute("customerMsg", (CustMsg)map.get("customerMsg"));
			}
		}
		return result;
		
	}
	
	@RequestMapping(value="/captcha", method=RequestMethod.GET)
	@ResponseBody
	public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");
      //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        logger.info("生成的字符串" + verifyCode);
        //存入会话session  
        HttpSession session = request.getSession(true);  
        session.setAttribute("verifyCode", verifyCode.toLowerCase());  
        //生成图片  
        int w = 100, h = 40;  
        try{
        	VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
        }catch(Exception e){
        	logger.error(e.getMessage());
        }
	}
	
	@RequestMapping(value="/checkCaptcha", method=RequestMethod.POST)
	@ResponseBody
	public Result checkCaptcha(HttpServletRequest request){
		String captcha = request.getParameter("captcha");
		logger.info("reqeust:" + captcha + "   session:" + request.getSession().getAttribute("verifyCode"));
		if(captcha != null){
			if(captcha.toLowerCase().equals(request.getSession().getAttribute("verifyCode"))){
				return new Result(true, null);
			}
		}
		return new Result(false, "验证码错误");
	}
	

}