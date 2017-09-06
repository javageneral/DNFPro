<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>workerLogin page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/workerLogin.css" />

  </head>
  
  <body>
      <div class="container">
     	 <h2 class="text-center title">员工登录</h2>
     	 <form class="text-center" action="/userlogin.action" method="POST">
     	 	  <input type="text" class="form-control form-group log_input" name="" placeholder="请输入员工帐号" id="username">
     	 	  <br>
     	 	  <input type="password" class="form-control form-group log_input" name="" placeholder="请输入密码" id="password">
              <br><br>
			  <p id="login_err" class="login_err"></p>
              <input type="button" class="btn btn-success" value="登录" onclick="userlogin()" >
     	 </form>
        </div>

    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="resources/js/workerlogin.js"></script>
  </body>
</html>
