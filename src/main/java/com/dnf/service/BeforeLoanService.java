package com.dnf.service;

import java.util.List;
import java.util.Date;
import com.dnf.entity.CustInfo;
import com.dnf.entity.OrderMessage;
import com.dnf.utils.Result;

public interface BeforeLoanService {
	
//	查询所有等待审核的客户信息
	Result query4customerInfo10N(int offset, int limit, int page, String state);
	
//  查询所有等待审核的客户的订单信息
	Result query4OrderMessage(int offset, int limit, int page, String state);
	
//	通过审核后更新客户信息状态
	Result update4customerInfo210F(String phoneNum);
	
//	审核不通过更新客户errorlog
	Result update4custInfoErrorLog(String log, String phoneNum);
	
//	根据条件模糊查询客户信息
	Result query4custInfo(String phoneNum, String name, String idCardNum, String cityCode, String sex, int page);
	
//  通过审核更新订单信息状态为10F 并插入1005
	Result update4OrderMessage(String orderId);

//  审核不通过，更新订单的errorlog
	Result update4OrderErrorLog(String lob, String orderId, String loanAmount, String phoneNum);
	
	/*
	 * 还款接口
	 */
	Result repayment(String orderId, String phoneNum, String password, String loanAmount);
}
