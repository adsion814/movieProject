<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    <link rel="shortcut icon" href="source/vv.png" type="source/kong.png" /> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" 
			integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<style>
			body{
				background: url(img/9612b3a2fcd8d73446c8858a60168808.jpg);
			}
			form{
				position: absolute;right: 100px;top: 100px;
				display: inline-block;
				width: 400px;
				height: 350px;
				padding: 10px;
				border: solid;
				border-color: azure;
				border-radius: 2em;
				background-color: rgba(250,250,250,0.5);
				box-shadow: 10px 10px 5px dimgray;
				}
			button{
				margin-left: 35%;
			}
	</style>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
	$("#T1").blur(function(){
	var email = $("#T1").val();
	var emailreg = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$"); 
	var ajax = createAjax();
	console.log(ajax.responseText);
	if(emailreg.test(email)){
	ajax.open("post","/movieProject/checkreg",true);
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){
			var text =  ajax.responseText;
			$("#tipId").html(text);
			console.debug(text);
			}
	};
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send("email="+email);
	}else{
		$("#tipId").html("请输入正确邮箱");
	}
	});
});
function createAjax() {
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		ajax = new ActiveXObject();	
	}
	return ajax;
}
function ret(){

	window.location.href="index.jsp";
}
	</script>
  </head>
  
  <body>
  <form action="register" method="post" id="f1">
    <div>
  	 	<span class="glyphicon glyphicon-envelope" style="color: rgb(0, 0, 0);">邮&nbsp;&nbsp;箱</span>
：		<input type="text" id="T1" name="email" placeholder="请输入邮箱" style="width: 60%;"/><span id="tipId""></span><br />
		<span class="glyphicon glyphicon-lock" style="color: rgb(0, 0, 0);">密&nbsp;&nbsp;码</span>
：		<input type="password" id="T2" name="password" placeholder="请输入密码" style="width: 60%;"/><br />
		<span class="glyphicon glyphicon-user" style="color: rgb(0, 0, 0);">用户昵称</span>
：		<input type="text" id="T3" name="nickname" placeholder="请输入昵称" style="width: 60%;"/><br /><br />
		<button id="B1" type="submit" class="btn btn-danger" ><span class="glyphicon glyphicon-log-in" style="color: azure;"> 注&nbsp;&nbsp;册</span></button>
		<br /><br />
		<span  class="glyphicon glyphicon-repeat" style="color: azure; left:130px;"><input type="button" id="B1" value="返回首页" onclick="ret()" class="btn btn-danger"> </span>
		
    </div>
   </form>
  </body>
</html>
