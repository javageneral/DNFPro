var data = [];
// 获取城市列表
$(function() {
			$.ajax({
						url : '../DNFPro/getCity',
						type : 'get',
						success : function(result) {
							if (result.success) {
								var str;
								for (var i = 0; i < result.data.length; i++) {
									str = "<option id='" + result.data[i].id
											+ "' name='"
											+ result.data[i].cityCode + "'>"
											+ result.data[i].city + "</option>";
									$("#city").append(str);
								}
							}
						}
					});
		});
		
		
function search(){
	document.getElementById("page").innerHTML=0;
	custMsgsearch()
}

function custMsgsearch() {
	var names = $("#names").val().trim();
	var gender = $("#gender").find("option:selected").attr("name");
	var idCardNum = $("#idCardNum").val().trim();
	var city = $("#city").find("option:selected").attr("name");
	var phoneNum = $("#phoneNum").val().trim();
	var url = "before/searchInfo/";
	var pagenum = parseInt(document.getElementById("page").innerHTML);
	pagenum = pagenum + 1;
	url = url + pagenum + "?";
	if(gender == 000){
		gender = "";
	}
	if(gender == "female"){
		gender ="女";
	}
	if(gender == "male"){
		gender = "男";
	}
	if(phoneNum != ""){
		url +="phone_num=" + phoneNum + "&";
	}
	if(idCardNum != ""){
		url +="id_card_num=" + idCardNum + "&";
	}
	if(city != 000){
		url += "city_code=" + city; 
	}
	$.ajax({
				url : url,
				type : "post",
				data : {
//					"id_card_num" : idCardNum,
					"names" : names,
					"sex" : gender,
//					"phone_num" : phoneNum,
//					"city_code" : city
				},
				dataType : "json",
				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
				success : function(result) {
					if (result.success) {
						data = result.data;
						$("#tbody").empty();
						dataDisplay(result.data);
						controlBtn(result);
					}
				},
				error : function(result) {
					// console(result);
				}
			});
}
function dataDisplay(result) {
	var str;
	for (var i = 0; i < result.length; i++) {
		str = "<tr>" + "<td>" + result[i].name + "</td>" + "<td>"
				+ result[i].sex + "</td>" + "<td>" + result[i].phoneNum
				+ "</td>" + "<td>" + result[i].city + "</td>" + "<td>"
				+ result[i].address + '</td><td><button type="button" class="btn btn-success btn-xs" id="'+ 
                result[i].phoneNum + '" onclick="modal('+ 
                result[i].phoneNum +')">查看信息</button></td></tr>';
		$("#tbody").append(str);
	}
}

function controlBtn(result) {
	document.getElementById("page").innerHTML = result.page;
	if (result.page * 10 >= result.total) {
		document.getElementById("pageRight").disabled = true;
	} else {
		document.getElementById("pageRight").disabled = false;
	}
	if (result.page > 1) {
		document.getElementById("pageLeft").disabled = false;
	} else {
		document.getElementById("pageLeft").disabled = true;
	}
}

function getlast() {
	var names = $("#names").val();
	var gender = $("#gender").find("option:selected").val();
	var idCardNum = $("#idCardNum").val();
	var city = $("#city").find("option:selected").val();
	var phoneNum = $("#phoneNum").val();
	var url = "before/searchInfo/";
	var pagenum = parseInt(document.getElementById("page").innerHTML);
	pagenum = pagenum - 1;
	url = url + pagenum;
	$.ajax({
				url : url,
				type : "get",
				success : function(result) {
					if (result.success) {
						dataDisplay(result.data);
						controlBtn(result);
					}
				}
			})
}
function modal(id){
    $("#mymodal").modal();
//    var pass = document.getElementById('pass');
//    pass.name = id;
//    var nopass = document.getElementById('nopass');
//    nopass.name = id;
    var modalMsg = document.getElementById('modalMsg');
    var str = '';
    for(var i=0;i<data.length;i++){
       if(data[i].phoneNum == id){
          str += '<img src="'+ data[i].idCardUpPhoto + '"alt="客户图片">' 
        	  + '<div><h4><span>姓名：</span>' + data[i].name 
          	  + '</h4><h4><span>身份证号：</span>' + data[i].idCardNum
              + '</h4><h4><span>地址：</span>' + data[i].address 
              + '</h4><h4><span>电话：</span>' + data[i].phoneNum
              + '</h4></div>' 
              ;
               $("#modalMsg").html("");
               $("#modalMsg").append(str);
       }
    }
}
