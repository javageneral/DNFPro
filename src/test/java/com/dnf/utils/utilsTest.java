package com.dnf.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class utilsTest {
	@Test 
	public void testReg(){
		String url = "resource/customer/13710004531/video/2017-08-04/2017080400001000180016325674video.mp4";
		String orderId = RegExputils.getOrderIdFromvideoUrl(url);
				
		System.out.println(orderId);
	}
	
	@Test
	public void testDate(){
		Calendar now = Calendar.getInstance();
		Date nowtime = now.getTime();
		System.out.println(nowtime.toString());
		now.add(Calendar.MONTH, 3);
		System.out.println(now.getTime().toString());
	}
}
