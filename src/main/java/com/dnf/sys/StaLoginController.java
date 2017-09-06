package com.dnf.sys;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnf.entity.Staff;
import com.dnf.service.StaffService;
import com.dnf.utils.CSRFToken;
import com.dnf.utils.Result;

@Controller
@RequestMapping("/sys")
public class StaLoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value="/userlogin.action",method=RequestMethod.POST)
	@ResponseBody
	public Result stalogin(HttpServletRequest request){
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		Result result = staffService.staffLogin(userName, password);
		if(result.isSuccess()){
			Staff staff = (Staff) result.getData();
			request.getSession().setAttribute("staff", staff);
		}
		return result;	
	}
	
}
