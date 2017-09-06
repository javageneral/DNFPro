package com.dnf.web;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dnf.dto.CustMsg;
import com.dnf.dto.WorkMsg;
import com.dnf.entity.CustAmount;
import com.dnf.entity.Customer;
import com.dnf.entity.OrderMessage;
import com.dnf.service.CustomerService;
import com.dnf.utils.FileUpload;
import com.dnf.utils.Orderutils;
import com.dnf.utils.RegExputils;
import com.dnf.utils.Result;


@Controller
@RequestMapping("/")
public class LoanController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 * 客户下贷款订单
	 */
	@RequestMapping(value="/loan.action", method=RequestMethod.POST)
	@ResponseBody
	public Result loanAction(HttpServletRequest request){
		String orderAmount = request.getParameter("loan_num");
		String loanPurpose = request.getParameter("loan_use");
		String creditCardId = request.getParameter("loan_bank_card_num");
		String loanPassword = request.getParameter("loan_password");
		String loanTime1 = request.getParameter("loan_time");
		String url = (String) request.getSession().getAttribute("loan_video_url");
		Customer cust = (Customer) request.getSession().getAttribute("customer");
		CustMsg custMsg = (CustMsg) request.getSession().getAttribute("customerMsg");
		Result result = customerService.loanOrder(orderAmount, loanPurpose, creditCardId, loanPassword, loanTime1, url, cust, custMsg);
		if(result.isSuccess()){
			//更新session客户余额信息
			CustAmount amount = (CustAmount)result.getData();
			CustMsg msg = (CustMsg)request.getSession().getAttribute("customerMsg");
			msg.updateAmount(amount);
			request.getSession().setAttribute("customerMsg", msg);
		}
		return result;
	}
	
	/*
	 * 上传贷款视频
	 */
	@RequestMapping("/info.loan_video")
	@ResponseBody
	public String loadVideo(@RequestParam("loan_video") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		Customer cust = (Customer) request.getSession().getAttribute("customer");
		String root = request.getSession().getServletContext().getRealPath("/");
		Result result = customerService.uploadVideo(file, cust, root);
		if(result.isSuccess()){
			request.getSession().setAttribute("loan_video_url", (String)result.getData());
		}
		return result.toString();
		
	}
	
	/*
	 * 客户查询订单记录
	 */
	@RequestMapping(value="/orderMsg.action", method=RequestMethod.POST)
	@ResponseBody
	public Result getOrderMsg(HttpServletRequest request) {
		Customer cust = (Customer) request.getSession().getAttribute("customer");
		String phoneNum = cust.getPhoneNum();
		String orderId = request.getParameter("orderId");
		String msgType = request.getParameter("msgType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Result result = customerService.searchOrdersByCust(cust, phoneNum, orderId, msgType, startDate, endDate);
		return result;
	}
	
	
}