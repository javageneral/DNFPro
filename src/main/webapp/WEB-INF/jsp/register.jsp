<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>register</title>

<link rel="stylesheet" type="text/css" href="resources/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resources/css/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->

</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">

						<h3>用户注册</h3>

						<form action="#" name="f" method="post">
							 <div class="input_box"> 
								<div class="input_outer">
									<span class="u_user"></span>
									<input id="regPhoneNum" name="registerPhoneNum" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入手机号码" onblur="checkPhone_reg()">
								</div>
								<p id="phone_err" class="error_msg"></p>
							  </div>	
                     
                             <div class="input_box"> 
								<div class="input_outer">
									<span class="us_uer"></span>
									<input id="regPassword" name="regPass" class="text" style="color: #FFFFFF !important; z-index:100;"value="" type="password" placeholder="请输入密码" onblur="checkPassword()">
							    </div>
							    <p id="password_err" class="error_msg"></p>
							 </div>

                             <div class="input_box"> 
								<div class="input_outer">
									<span class="us_uer"></span>
									<input id="regPasswordAgain" name="regPassAgain" class="text" style="color: #FFFFFF !important; z-index:100;"value="" type="password" placeholder="请再次输入密码" onkeyup="checkTwoPassword()">
								</div>
								 <p id="twoPassword_err" class="error_msg"></p>
							</div>	
                            
							<div>
								<input id="verification" class="verification" type="text" name="verification" placeholder="请输入手机验证码">
								<input id="btn_verification" class="btn_verification" type="button" name="btn_verification" value="获取验证码" >
							</div>

							<p class="register_err" id="register_err" ></p>
							
							<!-- 加入csrf校验码 防止非法请求 -->
							<input id="_csrf" type="hidden" value=${ _csrf} />

							<div class="mb2">
							     <input type="button" class="act-but submit" href="javascript:;" style="color: #FFFFFF" onclick="register()" value="注册">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
		<script src="resources/js/TweenLite.min.js" charset="utf-8" type="text/javascript"></script>
		<script src="resources/js/EasePack.min.js" charset="utf-8" type="text/javascript"></script>
		<script src="resources/js/rAF.js" charset="utf-8" type="text/javascript"></script>
		<script src="resources/js/demo-1.js" charset="utf-8" type="text/javascript"></script>
		<script src="resources/js/md5.js" charset="utf-8" type="text/javascript"></script>
		<script src="resources/js/register.js" charset="utf-8" type="text/javascript"></script>
	</body>
</html>