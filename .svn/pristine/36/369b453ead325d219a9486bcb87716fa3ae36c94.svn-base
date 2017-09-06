package com.dnf.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustUrlController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/login")
	public String loginPage(HttpServletRequest request){
		return "login";
	}
	
	@RequestMapping(value="/main")
	public String MainPage(){
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage(HttpServletRequest request){
		return "register";
	}
	
	@RequestMapping("/info")
	public String infoPage(){
		return "regInformation";
	}
}
