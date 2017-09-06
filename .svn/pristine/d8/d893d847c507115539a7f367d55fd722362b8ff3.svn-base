package com.dnf.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnf.dao.StaffDao;
import com.dnf.entity.Staff;
import com.dnf.service.StaffService;
import com.dnf.utils.Result;

@Service
public class StaffServiceImpl implements StaffService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffDao dao;
	
	/*
	 * 员工登录(non-Javadoc)
	 * @see com.dnf.service.StaffService#staffLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Result staffLogin(String userName, String password){
		
		Staff staff = dao.queryByUsername(userName);
		if(staff !=null){
			logger.info("登陆查询staff：" + staff.toString());
			if(password.equals(staff.getPassword())){
				return new Result<Staff>(true,staff);
			}else{
				return new Result(false,"密码错误");
			}
		}else{
			return new Result(false,"该用户不存在");
		}
	}

}
