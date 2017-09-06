package com.dnf.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dnf.dto.CustMsg;
import com.dnf.entity.CustInfo;
import com.dnf.entity.Customer;
import com.dnf.entity.OrderMessage;
import com.dnf.utils.Result;

public interface CustomerService {
	/*
	 * 注册时校验手机号码是否被注册
	 */
	Result checkPhoneidUsed(String phoneNum);
	
	/*
	 * 获取短信验证码 并将其存入缓存中
	 */
	Result getSmsCode(String phoneNum);
	
	/*
	 * 注册
	 */
	Result register(String phoneNum, String password, String smsNum);
	
	/*
	 * 填写注册信息
	 */
	Result registerInfo(Customer cust, String name, String idCardNum, String cityCode, String sex, String address,
			String idCardUpPhoto, String idCardDownPhoto, String creditCardNum);
	
	
//	 客户登录校验
	Result custLogin(String phoneNum, String password);
	
	/*
	 * 身份证照片上传
	 */
	Result photoUpLoad(MultipartFile file, Customer cust, String filename, String root);
	
	/*
	 * 客户下贷款订单
	 */
	Result loanOrder(String orderAmount, String loanPurpose, String creditCardId, String loanPassword, 
			String loanTime1, String url, Customer cust, CustMsg custMsg);
	
	/*
	 * 客户根据条件查询订单
	 */
	Result searchOrdersByCust(Customer cust, String phoneNum, String orderId, String msgType, String startDate, String endDate);
	
	/*
	 * 上传贷款视频
	 */
	Result uploadVideo(MultipartFile file, Customer cus, String root);
}
