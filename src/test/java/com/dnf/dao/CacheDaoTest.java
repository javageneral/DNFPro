package com.dnf.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dnf.BaseTest;
import com.dnf.entity.OrderParam;

public class CacheDaoTest extends BaseTest {
	
	@Autowired
	private CacheDao dao;
	
	@Test
	public void testGetParam(){
		List<OrderParam> list = dao.query4OrderMsgParam();
		for(OrderParam i : list){
			System.out.println(i.toString());
		}
	}
}
