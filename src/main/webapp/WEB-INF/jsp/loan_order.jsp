<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loan_order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  
      <p id="user_state" style="display:none;">${ customerMsg.state}</p>
            <p id="user_money">您的贷款额度:${ customerMsg.loanAmount}元 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp剩余贷款额度为: ${ customerMsg.restAmount}元 </p>
            <input id="restAmount" value="${ customerMsg.restAmount}" style="display:none;">
            <div class="line"></div>
	        <div class="space"></div>
            <div style="width:25rem; float:left; margin-top:-5rem;">
                <div class="input-group"  style="margin-top:6rem;">
                    <span class="input-group-addon" style="height:3rem;">银行卡号：</span>
                    <input id="loan_bank_card_num" name="loan_bank_card_num" class="form-control" placeholder="请输入您绑定的银行卡号" style="height:3rem;">
                </div>
                <div class="input-group"  style="margin-top:1rem;">
                    <span class="input-group-addon" style="height:3rem;">贷款时间：</span>
                    <select id="loan_time" name="loan_time" class="form-control" style="height:3rem;">
                        <option>1个月</option>
                        <option>3个月</option>
                        <option>半年</option>
                    </select>
                </div>
                <div class="input-group"  style="margin-top:1rem;">
                    <span class="input-group-addon" style="height:3rem;">贷款金额：</span>
                    <input id="loan_num" name="loan_num" class="form-control" placeholder="贷款金额必须为100的整数" style="height:3rem;">           
                </div>
                <p id="error" style="margin-left:5px; color:red; font-size:14px; display:none;">贷款金额必须为100的整数</p>
                <p id="error1" style="margin-left:5px; color:red; font-size:14px; display:none;">贷款金额不能大于贷款额度</p>
                <div class="input-group"  style="margin-top:1rem;">
                    <span class="input-group-addon" style="height:3rem;">贷款用途：</span>
                    <input id="loan_use" name="loan_use" class="form-control" style="height:3rem;">
                </div>
                <div class="input-group"  style="margin-top:1rem;">
                    <span class="input-group-addon" style="width:6.8rem;height:3rem;">密码：</span>
                    <input type="password" id="loan_password" name="loan_password" class="form-control" placeholder="再次输入您的密码" style="width:18.2rem;height:3rem;">
                </div>
            </div>
            <input type="file" name="loan_video" id="loan_video" style="display:none" onchange="checkVideo()">
            <div style="width:25rem; float:right; text-align:center;">
                <div id="video"></div>
                <a><img id="v_logo" src="resources/images/video.png" onclick="loan_video.click()"></a>
                <div id="file">                                 
                    <input type="button" id="btn" class="btn btn-success" value="上传个人录像" onclick="loan_video.click()">                          
                </div>
                <div class="input-group" style="width:27rem; position:absolute; z-index:3; font-size:15px; color:black; margin-top:225px; margin-left:1px;">
                    <span class="input-group-addon" style="height:3rem;">文件路径：</span>
                    <input id="upfile" name="loan_video_url" class="form-control" placeholder="未选择文件" style="height:3rem;">  
                </div>
                <p id="v_error" style="margin-top:300px; margin-left:10px; color:red; font-size:14px; display:none;">视频格式不符合</p>
            </div>
            <div>
                
                <input id="submit" type="button" class="btn btn-success" value="提交" onclick="loan_submit()" style="width:100px; margin-left:770px; margin-top:100px;">
            </div>
  
  </body>
</html>
