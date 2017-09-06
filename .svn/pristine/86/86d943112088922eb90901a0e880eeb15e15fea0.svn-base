<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repay_money.jsp' starting page</title>
    
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
    <div id="query">
                <div style="color:green; font-size:17px; text-align:left;">查询条件</div>
                <div class="space"></div>
                <div class="line"></div>
	            <div class="space"></div>
                <div>
                    <div class="input-group" style="width:85rem;">
                        <span class="input-group-addon">贷款单号:</span>
                        <input id="orderId" class="form-control" style="width:13rem;">
                        
                        <span class="input-group-addon">贷款状态:</span>
                        <select id="msgType" class="form-control" style="width:13rem;">
                            <option name="1003 1005 1008">全部</option>
                            <option name="1003">待审核</option>
                            <option name="1005">待还款</option>
                            <option name="1008">已还款</option>
                        </select>                       
                        <span class="input-group-addon">贷款时间:</span>
                        <input id="startDate" type="date" class="form-control">
                        <span class="input-group-addon">---</span>
                        <input id="endDate" type="date" class="form-control"> 
                    </div>
                </div>
                <div> 
                    <input type="button" class="btn btn-success" value="查询" onclick="repay_submit()" style="width:100px; margin-top:30px; margin-left:1090px;">
                </div>
                <button style="display:none;" id="a">11</button>
            </div>
            <div>     
                <table class="table table-hover " id="table" style="width:1150px; height:100px;">
                    <tr>
                        <th>贷款单号</th>
                        <th>贷款金额</th>
                        <th>贷款日期</th>
                        <th>贷款人</th>
                        <th>贷款状态</th>
                        <th></th>
                    </tr>
                    <tbody id="tbody">
                    </tbody> 
                </table>
            </div>
            
            <div>
                <ul id="pagination" class="pagination">
                    
                </ul>
            </div>
            
<!-- 模态弹出窗内容 -->
<div class="modal fade" id="modal" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" style="color:green;">您需支付</h4>
			</div>
			<div class="modal-body">
			    <span style="color:green; font-size:30px;">￥</span>
				<span id="user_repayMoney" style="color:green; font-size:30px;"></span>
				<div class="space"></div>
				<p id="user_repayCard" style="color:green"></p>
				<div class="input-group" style="width:350px; margin:0 auto;">
				    <span class="input-group-addon">密码：</span>
				    <input id="password_submit" class="form-control" type="password"/> 
				</div>
				<input style="display:none" id="num_submit">
				<input style="display:none" id="id_submit">
			</div>
			<div class="modal-footer">
				<input type="button" class="btn" style="color:white; background-color:#5DB85D" data-dismiss="modal" value="还款" onclick="userRepay_submit()">
			</div>
		</div>
	</div>
</div>
            
  </body>
</html>
