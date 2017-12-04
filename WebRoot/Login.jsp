<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
  <base href="<%=basePath%>">    
  <title>登录界面</title>
  <link rel="shortcut icon" href="source/vv.png" type="source/kong.png" />        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
	body{
				background: url(img/82cf1c813623c1319332a91d8999ba7a.jpg);
			}
			form{
				display: inline-block;
				border: solid;
				width: 400px;
				height: 350px;
				border-color: darkgrey;
				border-radius: 2em;
				padding: 10px;
				box-shadow: 10px 10px 5px #888888;
				overflow: hidden;
				position: absolute;left: 100px;top: 100px;
				background-color: rgba(116,116,116,0.5);
			}
			button{
				margin-left: 35%;
			}
	</style>
 </head>
 <script>
	$(function(){
	$("#randomCode").blur(function(){
	var email = $("#email").val();
	var password = $("#password").val();
	var randomCode = $("#randomCode").val();
	var ajax = createAjax();
	ajax.open("post","checkyzm",true);
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){
			var text =  ajax.responseText;
			$("#tipId").html(text);
			console.debug(text);
			}
	};
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send("&randomCode="+randomCode);
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
function changeRandomCode(){
	      document.getElementById("randomCodeImg").src="randomCode?"+new Date().getTime();
	  }

function ret(){
	window.location.href="index.jsp";
}
	</script>
 <body>




	  <form action="Login" method="post">
			<span class="glyphicon glyphicon-envelope" style="color: rgb(250, 250, 250);">&nbsp;邮&nbsp;箱</span>
：			<input type="text" id="email" name="email" placeholder="请输入密码" style="width: 60%;"/><br />
			<span class="glyphicon glyphicon-lock" style="color: rgb(250, 250, 250);">&nbsp;密&nbsp;码</span>
：			<input type="password" id="password" name="password" placeholder="请输入密码" style="width: 60%";/><br />
			<span class="glyphicon glyphicon-qrcode" style="color: rgb(250, 250, 250);">&nbsp;验证码</span>
：			<input type="text" id="randomCode" name="randomCode" placeholder="请输入验证码" style="width: 60%";/> 
       			<img alt="验证码" src="randomCode" title="看不清？点击切换"
       			onclick="changeRandomCode();" id="randomCodeImg">
       			<br />
       			<span id="tipId"></span><br />
			<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-log-in" style="color: azure;"> 登&nbsp;&nbsp;录</span></button><br />
<span  class="glyphicon glyphicon-repeat" style="color: azure; left:130px;"><input type="button" id="B1" value="返回首页" onclick="ret()" class="btn btn-info"> </span>
	</form>



	
	<c:if test="${!empty errorMessage }">
	<script type="text/javascript">
	alert("${errorMessage}");
	</script>
	<c:remove var="errorMessage"/>
	</c:if>
	

 </body>
</html>