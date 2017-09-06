package com.dnf.cache;

import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.dnf.BaseTest;

public class CacheTest extends BaseTest{
	public static void main(String[] args) throws InterruptedException{
		CacheManager.putContent("smsNum", "123456", 60000);
		while(true){
			Cache smsCache = CacheManager.getContent("smsNum");
			if(!smsCache.isExpired()){
				System.out.println("获取的smsNum:" + smsCache.getValue().toString() + "  " + new Date().getTime());
				Thread.sleep(10000);
			}else{
				System.out.print("cache已过期");
				CacheManager.invalidate("smsNum");
				break;
			}
		}	
	}
	
	public void method1(){
		CacheManager.putContent("13710004531" + "sms", 1, 600000);
	}
	public void methos2(){
		Cache cache1 = CacheManager.getContent("13710004531"+"sms");
		System.out.println(cache1.getValue().toString());
		CacheManager.putContent("123456", 12, 600000);
	}
	
	@Test
	public void test1(){
		method1();
		methos2();
		Cache cache2 = CacheManager.getContent("123456");
		System.out.println(cache2.getValue().toString());
	}
	
	@Test
	public void testFTP(){
		File file = new File("D:\\pic", "1422602440978.jpg");
//		boolean result = FtpUtil.getInstance().uploadFile(file, "13710004531.jpg", "/01/13710004531/idCard/");
//		System.out.println("result:" +  result);
	}
	
	@Test
	public void testDownload(){
		String filename = "id_card_up_photo1501337653821.jpg";
		String path = "DNFPro/customer/13710004530/idCard/";
		boolean result = FtpUtil.getInstance().downloadFile(path, filename);
		System.out.println("result:" +  result);
	}
}
