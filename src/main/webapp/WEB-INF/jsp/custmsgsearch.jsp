<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>customerApproval</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/css/usermain.css" />
<style>
.modal-backdrop {
	z-index: 0;
}
.modal-title{
	text-align:center;
	color: green;
	font-weight: bold;
	font-size: 18px;
}
#modalMsg img{
	width:450px;
	height:250px;
	padding-left:60px;
}
#modalMsg div{
	padding-left:100px;
	margin-top: 10px;
}
h4 span{
	font-weight:bold;
	color:green;
}
</style>

</head>

<body>

	<div class="wrap">
		<!-- 顶部公司名 -->
		<div class="title_wrap">
			<h5 class="title">贷你飞金融业务管理系统</h5>
		</div>
		<!-- 系统设置 -->
		<div id="cityManageCon"></div>
		<div id="personnelManageCon"></div>
		<div id="systemBackupCon"></div>
		<div id="dataRecoveryCon"></div>
		<div id="operationRecordCon"></div>

		<!-- 贷前账户管理 -->
		<div id="custInfoApproalCon"></div>
		<div id="custLoanApproalCon"></div>
		<div id="custInfoInquiryCon"></div>
		<div id="assignCon"></div>

		<!-- 贷后账户 -->
		<div id="overdueAccountCon"></div>
		<div id="overdueRemindCon"></div>
		<div id="overdueStatementCon"></div>

		<!-- 财务报表 -->
		<div id="loanListCon"></div>
		<div id="ledgerCon"></div>
		<div id="repaymentListCon"></div>

	</div>

	<div>
		<div class="nav-main">
			<div class="nav-box">
				<div class="nav">
					<ul class="nav-ul">
						<li><a href="sys/usermain" class="home"><span>首页</span>
						</a>
						</li>
						<li><a class="systemSet"><span>系统设置</span>
						</a>
						</li>
						<li><a class="preAccount"><span>贷前账户管理</span>
						</a>
						</li>
						<li><a class="aftAccount"><span>贷后账户管理</span>
						</a>
						</li>
						<li><a class="financialState"><span>财务报表</span>
						</a>
						</li>
						<li><a class="exit"><span>退出</span>
						</a>
						</li>
					</ul>
				</div>
				<div class="nav-slide">
					<div class="nav-slide-o"></div>
					<div class="nav-slide-o">
						<ul>
							<li id="cityManage"><a href="#"><span>地市管理</span>
							</a>
							</li>
							<li id="personnelManage"><a href="#"><span>人员权限管理</span>
							</a>
							</li>
							<li id="systemBackup"><a href="#"><span>系统备份</span>
							</a>
							</li>
							<li id="dataRecovery"><a href="#"><span>数据恢复</span>
							</a>
							</li>
							<li id="operationRecord"><a href="#"><span>操作记录查询</span>
							</a>
							</li>
						</ul>
					</div>
					<div class="nav-slide-o">
						<ul>
							<li id="custInfoApproal"><a href="sys/approval"><span>客户信息审批</span>
							</a>
							</li>
							<li id="custLoanApproal"><a href="sys/loan"><span>客户贷款审批</span>
							</a>
							</li>
							<li id="custInfoInquiry"><a href="sys/custmsg"><span>客户信息查询</span>
							</a>
							</li>
							<li id="assign"><a href="#"><span>分配功能</span>
							</a>
							</li>
						</ul>
					</div>
					<div class="nav-slide-o">
						<ul>
							<li id="overdueAccount"><a href="#"><span>逾期账户工作</span>
							</a>
							</li>
							<li id="overdueRemind"><a href="#"><span>逾期账单信息提醒</span>
							</a>
							</li>
							<li id="overdueStatement"><a href="#"><span>逾期情况报表</span>
							</a>
							</li>
						</ul>
					</div>
					<div class="nav-slide-o">
						<ul>
							<li id="loanList"><a href="#"><span>放款名单</span>
							</a>
							</li>
							<li id="ledger"><a href="#"><span>分类账</span>
							</a>
							</li>
							<li id="repaymentList"><a href="#"><span>还款名单</span>
							</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div style="margin-top:-870px;margin-left:150px;width:1000px;">
			<div style="color:green; font-size:17px; text-align:left;">查询条件：</div>
			<br />
			<div>
				<div class="input-group" style="width:85rem;">
					<span class="input-group-addon">姓名:</span> <input id="names"
						class="form-control" style="width:8rem;"> <span
						class="input-group-addon">性别:</span> <select id="gender"
						class="form-control" style="width:7rem;">
						<option name="000">全部</option>
						<option name="male">男</option>
						<option name="female">女</option>
					</select> <span class="input-group-addon">身份证号码:</span> <input
						id="idCardNum" class="form-control" style="width:15rem;">
					<span class="input-group-addon">所在城市：</span> <select id="city"
						class="form-control" style="width:8rem;">
						<option name="000">全部</option>
					</select> <span class="input-group-addon">电话号码：</span> <input id="phoneNum"
						class="form-control" style="width:8rem;">
				</div>
			</div>
			<div>
				<input type="button" class="btn btn-success" value="查询"
					onclick="search()"
					style="width:100px; margin-top:30px; margin-left:1090px;">
			</div>
			<button style="display:none;" id="a">11</button>
		</div>
		<div>
			<table class="table table-hover " id="table"
				style="width:1100px; height:100px;margin-left:130px;">
				<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>电话号码</th>
					<th>城市</th>
					<th>地址</th>
					<th>查看</th>
				</tr>
				<tbody id="tbody">
				</tbody>
			</table>
			
		</div>
		<div class="container">
			<button id="pageLeft" onclick="getlast()" class="btn btn-success" disabled>
				<strong>上一页</strong>
			</button>
			<span style="display:inline-block;width:25px;text-align:center"><strong
				id="page">0</strong> </span>
			<button id="pageRight" onclick="custMsgsearch()" class="btn btn-success" disabled>
				<strong>下一页</strong>
			</button>
		</div>

		<div>
			<ul id="pagination" class="pagination">

			</ul>
		</div>
	</div>
		<!-- 审批模态框 -->
		<div class="modal" id="mymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">客户信息</h4>
					</div>
					<div class="modal-body">
					    <div id="modalMsg"></div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->




	<script type="text/javascript"
		src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/usermain.js"></script>
	<script type="text/javascript" src="resources/js/custSearch.js"></script>
	<script type="text/javascript">

	</script>
</body>
</html>
