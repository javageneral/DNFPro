<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/index.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.slideBox.css" />
  </head>
  
  <body>
    <div class="container">
    	<div class="header">
    		<h2 class="header_title">贷你飞金融</h2>
    		<input id="index_log" type="button" class="btn btn-default header_input" onclick="window.location.href='login'"  value="登录">
    		<input id="index_reg" type="button" class="btn btn-default header_input" onclick="window.location.href='register'" value="注册">
    	</div>

    	<div class="middle">
    		<ul id="tab" class="nav nav-tabs nav-justified">
    			<li><a href="#home" data-toggle="tab">首页</a> </li>
    			<li><a href="#profile" data-toggle="tab">公司简介</a></li>
    			<li><a href="#sign" data-toggle="tab">最新签约</a></li>
    			<li><a href="#dynamic" data-toggle="tab">公司动态</a></li>
    			<li><a href="#contact" data-toggle="tab">联系我们</a></li>
    		</ul>
    		
    		<div id="tabContent" class="tab-content">
                <!-- 首页 -->
    		    <div class="tab-pane fade in active" id="home">
                    <div id="demo1" class="slideBox">
                    	<ul class="items">
                    		<li><a href=""><img src="resources/images/index1.jpg"></a></li>
                    		<li><a href=""><img src="resources/images/index2.jpg"></a></li>
                    		<li><a href=""><img src="resources/images/index3.jpg"></a></li>
                    	</ul>
                    </div>
    		    </div>
                <!-- 公司简介 -->
    		    <div class="tab-pane fade" id="profile">
                   <p class="profile_content"><strong>&nbsp&nbsp&nbsp&nbsp贷你飞金融业务公司是国内著名的金融ERP系统提供商。核心团队自2004年起就从事企业信息化应用服务，2008年起聚焦类金融行业的企业应用信息化系统服务，2014年专门注册“互融云(TM)软件”品牌，专注于金融信息化领域企业级应用及云服务。公司先后获得了四十余项的计算机软件著作权登记证书，称得上行业内第一家拥有全业务整合系统认证的软件提供商。公司团队经过12年的技术及行业经验积累，发展成为国内最为领先和专业的金融信息化综合服务商。
                   互融云科研力量强大，重视技术创新，对产品结构不断进行改善，不断提高产品质量、推陈出新，巩固了自己的品牌地位。公司业务涵盖小贷、网贷、车贷、财富管理、众筹、消费金融、供应链金融、交易所等各金融细分领域，自成立以来已经为接近千家的客户提供了专业的软件系统及金融解决方案，客户遍布全国各省市，亦包括很多国资运营公司及集团性企业。互融云始终秉持因为专业所以成功的信念，为每位签约客户均提供完全符合其业务经营模式的软件支持服务，并以客户口碑作为企业持续经营的基础，成长为行业内标杆级金融软件及解决方案提供商。</strong></p>
    		    </div> 
                <!-- 最新签约 -->
    		    <div class="tab-pane fade" id="sign">
    		    	<h2 class="sign_title">最新签约</h2>
    		    	<ul class="sign_ul">
    		    		<li class="sign_li"><a href="#">热烈祝贺华南农业大学与我司达成合作！</a><a class="sign_date" href="#">2017-08-01</a></li>
    		    		<li class="sign_li"><a href="#">热烈祝贺华南理工大学与我司达成合作！</a><a class="sign_date" href="#">2017-07-01</a></li>
    		    		<li class="sign_li"> <a href="#">热烈祝贺华南师范大学与我司达成合作！</a><a class="sign_date" href="#">2017-06-01</a></li>
    		    	</ul>
    		    </div>
                <!-- 公司动态 -->
    		    <div class="tab-pane fade" id="dynamic">
    		    	<h2 class="dynamic_title">公司动态</h2>
    		    	<ul class="dynamic_ul">
    		    		<li class="dynamic_li"><a href="#">建军节，向祖国士兵们致敬！</a><a class="dynamic_date" href="#">2017-08-01</a></li>
    		    		<li class="dynamic_li"><a href="#">端午节放假通知</a><a class="dynamic_date" href="#">2017-06-01</a></li>
    		    		<li class="dynamic_li"> <a href="#">贷你飞五一爬山运动</a><a class="dynamic_date" href="#">2017-05-01</a></li>
    		    	</ul>
    		    </div>
    		    <!-- 联系我们 -->
    		    <div class="tab-pane fade" id="contact">
    		    	<div class="contact_left">
    		    		<p class="contact_title">贷你飞金融</p>
    		    		<p class="contact_title">公司</p>
    		    	</div>

    		    	<div class="contact_right">
    		    		<h3 class="contact_right_title">联系地址:</h3>
    		    		<h4 class="contact_right_content"><strong>广东省广州市天河区五山街道华南农业大学泰山区</strong></h4>
    		    		<h3 class="contact_right_title">联系电话：</h3>
    		    		<h4 class="contact_right_content"><strong>18819250000</strong></h4>
    		    	</div>
    		    </div>
    		</div>
    	</div>
    </div>

    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="resources/js/jquery.slideBox.js"></script>
    <script type="text/javascript" src="resources/js/index.js"></script>
  </body>
</html>
