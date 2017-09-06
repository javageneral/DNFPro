<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/main.css?'+Math.random()+'" />
    <style>
        .modal-backdrop{
            z-index:0;
        }
    </style>
  </head>
  
  <body>

<div class="wrap">

	<div id="title" style="width:100%; height:100px; margin-top:-150px; background-color:#18222A; position:fixed; z-index:5">
		<p style="line-height:100px;">贷你飞金融业务管理系统</p>
	</div>

    <div id="info" style="margin-top:10rem;">
        <div id="loan_order">
            <jsp:include page="loan_order.jsp"/>
        </div>
        
        <div id="repay_money">                         
            <jsp:include page="repay_money.jsp" />
        </div>   
    </div>
</div>


<div class="nav-main">
<div class="nav-box">
<div class="nav">
  <ul class="nav-ul">
  	<li><a class="loan"><span>客户贷款</span></a></li>
  	<li><a class="repay"><span>客户还款</span></a></li>
  	<li><a class="about" href="#"><span>关于我们</span></a></li>
  	<li><a class="exit" href="logout"><span>退出</span></a></li>
  </ul>
</div>
<div class="nav-slide">
    <div class="nav-slide-o">
    	<ul>
    		<li id="loan"><a><span>我要贷款</span></a></li>
    	</ul>
    </div>
    <div class="nav-slide-o">
    	<ul>
    		<li id="repay"><a><span>我要还款</span></a></li>
    	</ul>
    </div>
</div>
</div>
</div>
  

    
     
    
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src='resources/js/bootstrap.js'></script>
    <script type="text/javascript" src="resources/js/main_all.js"></script>
    <script type="text/javascript" src='resources/js/md5.js'></script>
    <script type="text/javascript" src='resources/js/ajaxfileupload.js'></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-json/2.6.0/jquery.json.min.js"></script>

    
  </body>
</html>
