package com.dnf.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dnf.cache.Cache;
import com.dnf.cache.CacheManager;
import com.dnf.dto.CustMsg;
import com.dnf.entity.City;
import com.dnf.entity.CustAmount;
import com.dnf.entity.CustInfo;
import com.dnf.entity.Customer;
import com.dnf.service.CustomerService;
import com.dnf.utils.CSRFToken;
import com.dnf.utils.FileUpload;
import com.dnf.utils.RegExputils;
import com.dnf.utils.Result;
import com.dnf.utils.SendMessage;


@Controller
@RequestMapping("/")
public class RegisterController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 * 校验手机号码是否被注册
	 */
	@RequestMapping(value="/checkPhone", method=RequestMethod.POST)
	@ResponseBody
	public Result checkPhoneNum(HttpServletRequest request){
		String phoneNum = request.getParameter("phone_num");
		Result result = customerService.checkPhoneidUsed(phoneNum);
		return result;
	}
	
	/*
	 * 获取短信验证码 并将其存入缓存中
	 */
	@RequestMapping(value="/getSmsNum", method=RequestMethod.POST)
	@ResponseBody
	public Result getSmsNum(HttpServletRequest request){
		String phoneNum = request.getParameter("phone_num");
		Result result = customerService.getSmsCode(phoneNum);
		return result;
	}
	
	@RequestMapping(value="/register.action", method=RequestMethod.POST)
	@ResponseBody
	public Result register(HttpServletRequest request){		
//		校验token
//		if(!CSRFToken.checkToken(request)){
//			return new Result(false, "您的操作过于频繁，请刷新页面");
//		}	
		String phoneNum = request.getParameter("phone_num");
		String password = request.getParameter("password");
		String smsNum = request.getParameter("sms_num");
		Result result = customerService.register(phoneNum, password, smsNum);
		return result;
	}
	
	/*
	 * 从缓存中读取cityList
	 */
	@RequestMapping("/getCity")
	@ResponseBody
	public Result getCity(){
		List<City> list = (List<City>) CacheManager.getContent("cityList").getValue();
		return new Result(true, list);
	}
	
	/*
	 * 上传身份证正面照
	 */
	@RequestMapping("/info.id_card_up_photo")
	@ResponseBody
	public String idCardUpPhoto(@RequestParam("id_card_up_photo") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		Customer cust = (Customer) request.getSession().getAttribute("customer");	
		String filename = request.getParameter("photo_name");
		String root = request.getSession().getServletContext().getRealPath("/");
		Result result = customerService.photoUpLoad(file, cust, filename, root);
		if(result.isSuccess()){
			request.getSession().setAttribute("id_card_up_photo", (String)result.getData());
		}
		return result.toString();
	}
	
	
	@RequestMapping("/info.id_card_down_photo")
	@ResponseBody
	public String idCardDownPhoto(@RequestParam("id_card_down_photo") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		Customer cust = (Customer) request.getSession().getAttribute("customer");	
		String filename = request.getParameter("photo_name");
		String root = request.getSession().getServletContext().getRealPath("/");
		Result result = customerService.photoUpLoad(file, cust, filename, root);
		if(result.isSuccess()){
			request.getSession().setAttribute("id_card_down_photo", (String)result.getData());
		}
		return result.toString();
	}
	
	
	@RequestMapping("/info.action")
	@ResponseBody
	public Result registerInfo(HttpServletRequest request){
//		校验token
//		if(!CSRFToken.checkToken(request)){
//			return new Result(false, "您的操作过于频繁，请刷新页面");
//		}
		Customer cust = (Customer) request.getSession().getAttribute("customer");
		String name = request.getParameter("name");
		String idCardNum = request.getParameter("id_card_num");
		String cityCode = request.getParameter("city_code");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String idCardUpPhoto = (String) request.getSession().getAttribute("id_card_up_photo");
		String idCardDownPhoto = (String) request.getSession().getAttribute("id_card_down_photo");
//		银行卡号暂时不校验
		String creditCardNum = request.getParameter("credit_card_num");
		
		Result result = customerService.registerInfo(cust, name, idCardNum, cityCode, sex, address, idCardUpPhoto, idCardDownPhoto, creditCardNum);
		if(result.isSuccess()){
			Map<String, Object> map = (Map<String, Object>) result.getData();
			CustInfo custInfo = (CustInfo) map.get("custInfo");
			CustMsg customerMsg = (CustMsg) map.get("customerMsg");
			request.getSession().setAttribute("custInfo", custInfo);
			request.getSession().setAttribute("customerMsg", customerMsg);
		}
		return result;
	}
	
	

}
