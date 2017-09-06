package com.dnf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dnf.dto.WorkMsg;
import com.dnf.entity.OrderMessage;

public class Orderutils {
	
	private static Logger logger = LoggerFactory.getLogger(Orderutils.class);
	
	public static String getOrderId(){
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());  
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());  
        String orderId = null;
        for (int i = 0; i < 10000; i++) {  
        	orderId = date + "00001000" + getTwo() + "00" + seconds + getTwo();  
        }  
        return orderId;
	}
	
	/** 
     * 产生随机的2位数 
     * @return 
     */  
    public static String getTwo(){  
        Random rad=new Random();  
        String result  = rad.nextInt(100) +"";  
        if(result.length()==1){  
            result = "0" + result;  
        }  
        return result;  
    } 
    
    public static WorkMsg processOrderxml(OrderMessage msg){
    	String ordermsg = msg.getOrderMsg();
    	logger.info(ordermsg);
		Document orderDetail = null;
		WorkMsg workmsg = null;
		try {
			orderDetail = DocumentHelper.parseText(ordermsg);
			Element root = orderDetail.getRootElement();
			String xphoneNum = root.element("phone_num").getData().toString();
			String xorderId = root.element("order_id").getData().toString();
			String xcustName = root.element("cust_name").getData().toString();
			String xcreditCardId = root.element("credit_card_id").getData().toString();
			String xidCardNum = root.element("id_card_num").getData().toString();
			String xorderAmount = root.element("order_amount").getData().toString();
			String xvideoUrl = root.element("video_url").getData().toString();
			String xcityCode = root.element("city_code").getData().toString();
			String xloanPurpose = root.element("loan_purpose").getData().toString();
			String xloanTime = root.element("loan_time").getData().toString();
			String xcreateDate = RegExputils.formatDate(msg.getCreateDate());
			String xmsgType = msg.getMsgType();
			workmsg = new WorkMsg(xcustName,xphoneNum,xcreditCardId,xidCardNum,xorderId,
					xorderAmount,xvideoUrl,xcityCode,xloanPurpose,xloanTime,xcreateDate,xmsgType);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	return workmsg;
    }
}
