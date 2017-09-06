package com.dnf.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
/**
 *
 * @author lingshufeng
 */
public class SendMessage {
	private static final String LUOSIMAO_USER = "api";                 
	private static final String urlSendSingle = "http://sms-api.luosimao.com/v1/send.json"; //发送单条短信接口
	private static final String urlSendBatch = "http://sms-api.luosimao.com/v1/send_batch.json"; //发送批量短信接口
	private static final String urlSerchString = "http://sms-api.luosimao.com/v1/status.json"; //账户查询接口
	private static final String MESSAGE_MODEL_STRING = "【铁壳测试】"; //短信签名    应与luosimao账户中设置的签名一致，如果不一致则不可用
	public static Map<String, String> responseMap =new HashMap<String, String>();
	private String keyString; //验证密码
	public SendMessage(String keyString){
		this.keyString = keyString;
	}
	/**
	 * 执行方法入口---发送短信
	 * @return 返回发送状态信息
	 */
    public String MessageExecuteMethod(Map<String,String> dataMap){
    	String resultString = null;
        if(dataMap ==null){
        	return null; //短信内容为空 或者 错误的手机号
        }
        String mobile = dataMap.get("mobile"); //手机号
        String messageString = dataMap.get("message")+MESSAGE_MODEL_STRING; //发送短信内容
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("message", messageString); //必须要在luosimao官网上添加短信模板，并且这里的信息要符合短信模板的要求，这样发送的时候就不会经过他们进行审核，发送速度快
        if(!StringUtils.isEmpty(mobile)){ //手机号码不为空
        	if(mobile.split(",").length<2){ //单条信息
        		formData.add("mobile", mobile);  		
        		resultString = SendMessageMethod(formData,urlSendSingle);
        	}else{
        		formData.add("mobile_list", mobile);
        		resultString = SendMessageMethod(formData,urlSendBatch); 	
        	}
        }else{
        	formData.add("moblie", "");
        	resultString = SendMessageMethod(formData,urlSendSingle);
        }
        return resultString;
    }
    /**
     * 执行方法入口----账户查询
     * @return map 如果交互成功会有两个key  "code"表示返回状态代码,"msg"表示返回信息
	 *      
     */
    public Map<String,String> UserInfoSearchMethod(){
    	Map<String,String> resultMap = SearchUserDetails(urlSerchString);
        return resultMap;
    }
    /**
     * 发送短信逻辑
     */
    public String SendMessageMethod(MultivaluedMapImpl formData,String urlString){
    	String responseString = null;
    	Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(LUOSIMAO_USER,"key-"+this.keyString));
    	WebResource webResource = client.resource(urlString);  	
        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        try {
            JSONObject jsonObj = new JSONObject( textEntity );
            String error_code = jsonObj.getInt("error")+"";
            responseString= responseMap.get(error_code);     
        } catch (JSONException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseString;
    }
    /**
     * 账户信息（查询余额）
     */
    private Map<String, String> SearchUserDetails(String urlString){
    	Map<String, String> resultMap = new HashMap<String,String>();
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(LUOSIMAO_USER,"key-"+this.keyString));
        WebResource webResource = client.resource(urlString);
        ClientResponse response =  webResource.get( ClientResponse.class );
        String textEntity = response.getEntity(String.class);
        try {
            JSONObject jsonObj = new JSONObject( textEntity );
            String error_code = jsonObj.getInt("error")+"";
            
            String deposit = jsonObj.getInt("deposit")+"";
            resultMap.put("code", responseMap.get(error_code));
            resultMap.put("counts", deposit);
        } catch (JSONException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultMap;
    }
    public static void main(String[] args) {
    	SendMessage sendMessage = new SendMessage("d20decc373155e74e46498551030457a");//对应luosimao注册账号的key
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("mobile", "13710004531");
    	map.put("message", "您好【铁壳测试】"); //符合该注册账号中的短信模板会提高发送速度
        String telResponse =  sendMessage.MessageExecuteMethod(map);
        System.out.println(telResponse);
        Map<String, String> userResponse =  sendMessage.UserInfoSearchMethod();
        System.out.println("User_code"+userResponse.get("code"));
        System.out.println("Remain_counts"+userResponse.get("counts"));   
    }
    static{
    	if(responseMap.isEmpty()){
    		responseMap.put("0","发送成功");
    		responseMap.put("-10","验证信息失败");
    		responseMap.put("-11","用户接口被禁用");
    		responseMap.put("-20","短信余额不足");
    		responseMap.put("-30 ","短信内容为空");
    		responseMap.put("-31","短信内容存在敏感词");
    		responseMap.put("-32","短信内容缺少签名信息");
    		responseMap.put("-33","短信过长，超过300字（含签名）");
    		responseMap.put("-34","签名不可用");
    		responseMap.put("-40","错误的手机号");
    		responseMap.put("-41","号码在黑名单中");
    		responseMap.put("-42","验证码类短信发送频率过快");
    		responseMap.put("-43","号码数量太多");
    		responseMap.put("-50","请求发送IP不在白名单内");
    		responseMap.put("-60","定时时间为过去");
    	}
    }
}