package com.dnf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dnf.entity.Staff;

/**
 * @author HY
 *
 */
public interface StaffDao {
	
	List<Staff> queryAllstaff(@Param("offset") int offset, @Param("limit") int limit);
	
	Staff queryByUsername(String userName);
	
	int insert2Staffs(@Param("userName")String userName, @Param("password")String password);
	
	
	List<Staff> query4staff(String sql);
}
