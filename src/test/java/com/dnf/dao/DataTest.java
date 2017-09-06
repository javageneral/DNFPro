package com.dnf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dnf.BaseTest;
import com.dnf.service.BeforeLoanService;


public class DataTest extends BaseTest{
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private BeforeLoanDao ldao;
	
	@Autowired
	private BeforeLoanService lservice;
	
	@Test
	public void insertData(){
		lservice.query4customerInfo10N(0, 10, 1, null);
		
	}
}
