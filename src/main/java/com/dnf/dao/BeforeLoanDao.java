package com.dnf.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dnf.entity.CustAmount;
import com.dnf.entity.CustInfo;
import com.dnf.entity.OrderMessage;

public interface BeforeLoanDao {
//	查询所有等待审核的客户信息
	List<CustInfo> query4customerInfo10N(@Param("value") String sql);
	
//	查询所有等待审核的客户信息数量
	int query4countInfo10N(@Param("value")String sql);
	
//	通过审核后更新客户信息状态
	int update4customerInfo210F(@Param("phoneNum")String phoneNum, @Param("nowDate")Date date);
	
//	审核不通过更新客户errorlog
	int update4custInfoErrorLog(@Param("log") String log, @Param("phoneNum") String phoneNum, @Param("nowDate")Date date);

//  查询所有等待审核的订单信息
	List<OrderMessage> query4OrderMessage(@Param("value") String sql);
	
//  查询所有等待审核的订单信息数量
	int query4CountOrdermsg(@Param("value")String sql);
	
	
	
//	根据姓名查询模糊客户信息 这里的传值需要传 %name% 否则会报错
	List<CustInfo> query4custInfobyName(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);
	
//	根据电话号码模糊查询客户信息
	List<CustInfo> query4custInfobyPhoneNum(@Param("phoneNum") String phoneNum, @Param("offset") int offset, @Param("limit") int limit);

//	根据条件模糊查询客户信息
	List<CustInfo> query4custInfo(@Param("value") String sql);
	
//	根据模糊条件查询客户条数
	int query4custInfoCount(@Param("value") String sql);
	
//  通过审核更新订单信息状态
	int updateOrderMessage(@Param("orderId")String orderId, @Param("nowDate") Date date, @Param("msgType")String msgType);
	
//  审核不通过更新订单errorlog
	int update4OrderErrorLog(@Param("log") String log, @Param("orderId") String orderId, @Param("nowDate")Date date);
	
	OrderMessage query4OrderMessage10F(@Param("orderId") String orderId, @Param("msgType") String msgType);
	
	int insert4OrderMessage(@Param("orderId")String orderId, @Param("msgType") String msgType, @Param("state")String state,
			@Param("phoneNum") String phoneNum, @Param("orderMsg") String orderMsg,
			@Param("createDate")  Date createDate, @Param("cityCode") String cityCode,
			@Param("loanTime") Date loanTime);
	
	/*
	 * 客户下单后更新客户额度
	 */
	int updateCustAmount(@Param("usedAmount") int usedAmount, @Param("restAmount") int restAmount, @Param("phoneNum") String phoneNum);
	
	/*
	 * 查询客户账户信息
	 */
	CustAmount query4CustAmountbyPhoneNum(String phoneNum);
}

