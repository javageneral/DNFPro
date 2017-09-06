package com.dnf.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dnf.BaseTest;
import com.dnf.entity.Staff;

public class StaffTest extends BaseTest{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffDao dao;
	
	@Test
	public void testGetStaff(){
		String username = "张三丰";
		Staff sf = dao.queryByUsername(username);
		if(sf != null){
			System.out.println(sf.toString());
		}
	}
	
	@Test
	public void testStaInsert(){
		String username = "sblinjiawei";
		String password = "12345678";
		int rs = dao.insert2Staffs(username, password);
		System.out.println(rs);
	}
	
	@Test
	public void query4staff(){
		String sql = "SELECT id,user_name,password FROM staffs";
		List<Staff> list = dao.query4staff(sql);
		for(Staff staff : list){
			logger.info(staff.toString());
		}
	}
	
	@Test
	public void testElement() throws DocumentException{
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><workMsg><cust_name>黎志亮</cust_name>" +
				"<phone_num>13710004532</phone_num>" +
				"<credit_card_id>21221</credit_card_id>" +
				"<id_card_num>445381199605077839</id_card_num>" +
				"<order_amount>100</order_amount><order_id>1</order_id>" +
				"<video_url></video_url><city_code>01</city_code>" +
				"<loan_purpose>13710004532</loan_purpose>" +
				"<loan_time>6</loan_time></workMsg>";
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		String str = root.element("cust_name").getData().toString();
		System.out.println(str);
	}
	
}
