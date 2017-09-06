package com.dnf.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dnf.BaseTest;
import com.dnf.entity.City;
import com.dnf.entity.CustAmount;
import com.dnf.entity.CustInfo;
import com.dnf.entity.Customer;
import com.dnf.entity.OrderMessage;
import com.dnf.utils.RegExputils;

public class CustomerTest extends BaseTest {

	@Autowired
	private CustomerDao dao;

	@Test
	public void queryAllCust() {
		List<Customer> list = dao.queryAllCust(0, 20);
		for (Customer cust : list) {
			System.out.println(cust.toString());
		}

		Customer cus = dao.queryByPhoneNum("marco");
		System.out.println(cus.toString());

	}

	@Test
	public void smsService() {
		SendMessage sm = new SendMessage("d20decc373155e74e46498551030457a");
		Map<String, String> map = new HashMap<String, String>();
    	map.put("mobile", "13710004531");
    	map.put("message", "您好【铁壳测试】"); //符合该注册账号中的短信模板会提高发送速度
        String telResponse =  sm.MessageExecuteMethod(map);
        System.out.println(telResponse);
        Map<String, String> userResponse =  sm.UserInfoSearchMethod();
        System.out.println("User_code"+userResponse.get("code"));
        System.out.println("Remain_counts"+userResponse.get("counts"));   		
	}
	
	@Test
	public void insert2customers(){
		String phoneNum = "13710004531";
		String password = "123456";
		int i = dao.insert2Customers(phoneNum, password);
		System.out.println(i);
	}
	
	@Test
	public void query4CustInfoByPhoneNum() throws ParseException{
		String phoneNum = "13710004531";
		CustInfo info = dao.query4CustInfoByPhoneNum(phoneNum);
		System.out.println(info.toString());
		System.out.println(RegExputils.formatDate(info.getCreateDate()));
	}
	
	@Test
	public void query4CustAmountByPhoneNum() {
		String phoneNum = "13710004531";
		CustAmount amount = dao.query4CustAmountByPhoneNum(phoneNum);
		System.out.println(amount.toString());
	}
//	
//	@Test
//	public void testFileUpload(){
//		CommonsMultipartFile file = new CommonsMultipartFile(new File("‪D:\\pic\\55ee15b0ca93d5f.jpg" ));
//		
//		file.renameTo(new File("13710004531up.jpg"));
//		String path = "/DNFPro/src/main/webapp/resources/customer/" + "13710004531" + "/idCard";
//		try{
//			InputStream is = file.getInputStream();
//			OutputStream os = new FileOutputStream(new File(path, file.getOriginalFilename()));
//			int len=0;
//			byte[] buffer = new byte[400000];
//			while((len = is.read(buffer)) != -1)
//				os.write(buffer,0,len);
//			os.close();
//			is.close();
//		}
//	}
	
//	@Test
//	public void getCityCode(){
//		List<City> list = dao.query4CityName();
//		for(City city : list){
//			System.out.println(city.toString());
//		}
//	}
	
	@Test
	public void insert2customerInfo(){
		long id = 0;
		String phoneNum = "12345678911";
		String name = "陈大招";
		String idCardNum = "4453811996050778XX";
		String city = "广州";
		String cityCode = "01";
		String sex = "男";
		String address = "广州海珠区";
		String idCardUpPhoto = "/resource/aaa";
		String idCardDownPhoto = "resoutce/ssss";
		String state = "10N";
		Date createDate = new Date();
		try{
			int i = dao.insert2CustomerInfo(id, phoneNum, name, idCardNum, city, cityCode, sex, address, idCardUpPhoto, idCardDownPhoto, state, createDate);
			System.out.println("i:" + i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void insert2customerAmount(){
		long id = 0;
		String phoneNum = "12345678911";
		int loanAmount = 5000;
		int usedAmount = 0;
		int restAmount = 5000;
		String card = "123";
		try{
			int i = dao.insert2customerAmount(id, phoneNum, loanAmount, usedAmount, restAmount, card);
			System.out.println("i:" + i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void query4OrderMessageByPhoneNum(){
//		String phoneNum = "13710004532";
//		List<OrderMessage> list = dao.query4OrderMessageByPhoneNum(phoneNum);
		String sql = "select * from dnf_order_msg";
		List<OrderMessage> list = dao.query4OrderMessage(sql);
		for(OrderMessage orderMsg : list){
			System.out.println(orderMsg.toString());
			System.out.println();
		}
	}
	
	
}
