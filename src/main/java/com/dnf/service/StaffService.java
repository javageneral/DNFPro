package com.dnf.service;

import com.dnf.utils.Result;

public interface StaffService {
	/*
	 * 员工登录
	 */
	Result staffLogin(String userName, String password);
}
