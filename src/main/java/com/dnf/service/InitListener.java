package com.dnf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dnf.cache.CacheManager;
import com.dnf.dao.CacheDao;
import com.dnf.entity.City;
import com.dnf.entity.OrderParam;

@Component("InitListener") 
public class InitListener implements  ApplicationListener<ContextRefreshedEvent>{
	
	private static Logger logger = LoggerFactory.getLogger(InitListener.class);
	
	@Autowired
	private CacheDao dao;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent  event) {
		// TODO Auto-generated method stub
		logger.info("spring准备加载缓存");
		if (event.getApplicationContext().getParent() == null) { 
//			加载地市信息
			List<City> list = dao.query4CityName();
			if(list != null){
				CacheManager.putContent("cityList", list, -1);
			}
			Map<String, String> cityMap = new HashMap<String, String>();
			for(City city : list){
				cityMap.put(city.getCityCode(), city.getCity());
				logger.info("code: " + city.getCityCode() + "  city: " + city.getCity());
			}
			CacheManager.putContent("cityMap", cityMap, -1);
			
			
//			加载orderParam
			List<OrderParam> paramList = dao.query4OrderMsgParam();
			if(paramList != null){
				CacheManager.putContent("orderParam", paramList, -1);
			}
			logger.info("spring初始化加载缓存完毕"); 
			
		} 
	}
}
