<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

#modalMsg{
    color:green;
    padding-left:40px;
}

#modalMsg span{
    color:black;
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
						<li><a href="sys/usermain" class="home"><span>首页</span> </a>
						</li>
						<li><a class="systemSet"><span>系统设置</span> </a>
						</li>
						<li><a class="preAccount"><span>贷前账户管理</span> </a>
						</li>
						<li><a class="aftAccount"><span>贷后账户管理</span> </a>
						</li>
						<li><a class="financialState"><span>财务报表</span> </a>
						</li>
						<li><a class="exit"><span>退出</span> </a>
						</li>
					</ul>
				</div>
				<div class="nav-slide">
					<div class="nav-slide-o"></div>
					<div class="nav-slide-o">
						<ul>
							<li id="cityManage"><a href="#"><span>地市管理</span> </a>
							</li>
							<li id="personnelManage"><a href="#"><span>人员权限管理</span>
							</a>
							</li>
							<li id="systemBackup"><a href="#"><span>系统备份</span> </a>
							</li>
							<li id="dataRecovery"><a href="#"><span>数据恢复</span> </a>
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
							<li id="assign"><a href="#"><span>分配功能</span> </a>
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
							<li id="loanList"><a href="#"><span>放款名单</span> </a>
							</li>
							<li id="ledger"><a href="#"><span>分类账</span> </a>
							</li>
							<li id="repaymentList"><a href="#"><span>还款名单</span> </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div style="margin-top:-870px;margin-left:200px;width:1000px;">
			<form action="" class="form-group">
				<select id="option" class="form-control" style="width:100px;"
					onchange="show()">
					<option value="1">全部</option>
					<option value="2">已审批</option>
					<option value="3">未审批</option>
				</select>
			</form>

			<table id="approvalMsg" style="text-align:center"
				class="table table-border table-hover table-striped table-responsive">
				<tr>
					<th style="color:green; text-align:center">订单号</th>
					<th style="color:green; text-align:center">贷款人</th>
					<th style="color:green; text-align:center">贷款金额</th>
					<th style="color:green; text-align:center">贷款用途</th>
					<th style="color:green; text-align:center">贷款状态</th>
					<th style="color:green; text-align:center">操作</th>
				</tr>
			</table>

			<button id="pageLeft" onclick="getlast()" class="btn btn-success" >
				<strong>上一页</strong>
			</button>
			<span style="display:inline-block;width:25px;text-align:center"><strong
				id="page">0</strong> </span>
			<button id="pageRight" onclick="next()" class="btn btn-success">
				<strong>下一页</strong>
			</button>
			
		</div>
		<!-- 审批模态框 -->
		<div class="modal" id="mymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 style="color:green" class="modal-title">客户信息审批</h4>
					</div>
					<div class="modal-body">
					    <div id="modalMsg"></div>
						<input id="noPassMsg" class="form-control" type="text"
							placeholder="请输入审批不通过原因">
					</div>
					<div class="modal-footer">
						<button id='nopass' onclick="nopass(this.name)" type="button"
							class="btn btn-default" data-dismiss="modal">不通过</button>
						<button id='pass' onclick="pass(this.name)" type="button"
							class="btn btn-primary" data-dismiss="modal">通过</button>
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
		<script>  
		
		var nowPageData =null;
   
       $(function(){
          next();
       });
       
       function show(){
          document.getElementById("page").innerHTML=0;
          next();
       } 
       
       //下一页
       function next(){
           var option = document.getElementById("option").value;
           //alert(option);
           var pagenum = parseInt(document.getElementById("page").innerHTML);      
           pagenum = pagenum + 1;
           var url = "before/getOrderMessage/" + pagenum;
           if(option == 2){
              url = url + "?state=10F";
           }
           if(option == 3){
              url = url + "?state=10N";
           }
           $.ajax({
           		url: url,
             	type:'get',
             	success:function(result){
             		if(result.success){
             			appendHtml(result);
             			controlBtn(result);
             			nowPageData = result.data;
             		}
             	}
           })
           
       }
       
       //上一页
       function getlast(){
       		var pagenum = parseInt(document.getElementById("page").innerHTML);
       		pagenum = pagenum - 1;
       		var option = document.getElementById("option").value;
       		url = "before/getOrderMessage/" + pagenum;
       		if(option == '2'){
       			url = url + "?state=10F";
       		}
       		if(option == '3'){
       			url = url + "?state=10N";
       		}
       		$.ajax({
       			url: url,
       			type: "get",
       			success:function(result){
       				if(result.success){
       					appendHtml(result);
       					controlBtn(result);
       					nowPageData = result.data;
       				}
       			}
       		})  		
       }
       
       //页数码样式
       function controlBtn(result){
       		document.getElementById("page").innerHTML=result.page;
             			if(result.page*10 >= result.total){
             				document.getElementById("pageRight").disabled=true;
             			}else{
             				document.getElementById("pageRight").disabled=false;
             			}
             			if(result.page > 1){
             				document.getElementById("pageLeft").disabled=false;
             			}else{
             			 	document.getElementById("pageLeft").disabled=true;
             			}
       }
       
       //审批模态框
       function modal(i){
             $("#mymodal").modal();
             
             var data=nowPageData;
             $("#pass").attr("name",i);
             $("#nopass").attr("name",i);
           
             var str = '';
             str += '订单号：<span>' + data[i].orderId + '</span></br></br>'+
                     '姓名：<span>' + data[i].custName+ '</span></br></br>'+
                  '贷款金额：<span>' + data[i].orderAmount + '</span></br></br>'+
                  '贷款目的：<span>' + data[i].loanPurpose+ '</span></br></br>'+
                  '个人录像：<span><video width="500px" height="300px" poster="resources/images/video_fail.png" controls src="'+ data[i].videoUrl + '" >';
                  $("#modalMsg").html("");
                  $("#modalMsg").append(str);
       };
       //审核通过
      function pass(i){
          var order_id=nowPageData[i].orderId;
          $.ajax({
             url:'before/updateOrderMessage',
             type:'post',
             dataType:'json',
             data:{"order_id":order_id},
             success:function(result){
                  if(result.success){
                     alert("提交成功");
                     location.reload();
                  }
             },
              error:function(err){
                    alert("提交失败");
                    location.reload();
             }
          })
       }
       //审核不通过
       function nopass(i){
          var order_id=nowPageData[i].orderId;
          var error_log = document.getElementById('noPassMsg').value;
          var phone_num =nowPageData[i].phoneNum;
          var loanAmount=nowPageData[i].orderAmount;
          
          if(error_log == ''){
             alert("请输入审批不通过原因");
          }else{
             $.ajax({
             url:'before/setOrdererrorlog',
             type:'post',
             dataType:'json',
             data:{
             "order_id":order_id,
             "error_log":error_log,
             "phone_num":phone_num,
             "loanAmount":loanAmount
             },
             success:function(result){
                  if(result.success){
                     alert("提交成功");
                     location.reload();
                  }
             },
             error:function(err){
                alert("提交失败");
                location.reload();
             }
           })
          }
       }
       
       //显示用户数据
       function appendHtml(result){
            console.log(result);
            
                    var str = "";             
                    for(var j=0;j<result.data.length;j++){
                        if(result.data[j].state=="10N"){result.data[j].state="未审批";}
                        else {result.data[j].state="已审批";}
                        str += '<tr><td>' + result.data[j].orderId + 
                               '</td><td>' + result.data[j].custName + 
                               '</td><td>'+ result.data[j].orderAmount + 
                               '</td><td>' + result.data[j].loanPurpose + 
                               '</td><td>' + result.data[j].state + 
                               '</td>';
                    if(result.data[j].state == "未审批"){
                        str +='<td><button type="button" class="btn btn-success btn-xs"  onclick="modal('+j+')">审批</button></td></tr>'
                    }
                    else{
                        str +='<td><button type="button" class="btn btn-success btn-xs"  onclick="modal('+j+')" disabled>审批</button></td></tr>'
                    }
                    }

                    
                    $("#approvalMsg tr:not(:first)").html("");
                    $("#approvalMsg").append(str);

       }
       
       

       

   
   </script>
</body>
</html>
