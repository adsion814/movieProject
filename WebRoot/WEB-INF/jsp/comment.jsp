<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>视频评论</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/comment.css">

<script type="text/javascript">
	$(function() {
	//添加
	a();
		$("#btn").click(function(){
			var content = $("#top-textarea").val();
			$.ajax({
				type:"post",
				url:"commentadd/"+"${videouuid}",
				contentType:"application/json;charset=utf-8",
				data:('"'+content+'"'),
		        success:function(){
		        	a();
					$("#top-textarea").text("");
		        }
				
			
			
				});
			
			
			

  	 	
			
			
  	 	});

		$("#more-btn").click(function() {
			$("#more-2").toggle();
		});
	});
	//查看全部评论
	 function a(){
			var ajax = createAjax();
			ajax.open("post","commentall/"+"${videouuid}?"+Math.random(),true);
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){
			var JsonStr = ajax.responseText;
	
			var JsonObj = eval("("+JsonStr+")");
		     $("#ac").html(JsonObj.length);
		
			var html = "";
			var html1 = "";
			var j=3;
			if(JsonObj.length<=j){j=JsonObj.length}
			for(var i=0;i<j;i++){
				html +="<li class='comment-d'><div><span style='color: red'>"+
					JsonObj[i].name+"</span><span style='color: green'>"+
					JsonObj[i].time+"</span></div><div><p id='comment-content'>"+
					JsonObj[i].comment+"</p></div></li>";
			}
			for(var i=3;i<JsonObj.length;i++){
				html1 +="<li class='comment-d'><div><span style='color: red'>"+
				JsonObj[i].name+"</span><span style='color: green'>"+
				JsonObj[i].time+"</span></div><div><p id='comment-content'>"+
				JsonObj[i].comment+"</p></div></li>";
			} 
			 $("#ul").html(html);
			 $("#ul1").html(html1);
			 $("#count").html(JsonObj.length);
			}
	};
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send();
	}
	//查看个人评论
	function b(){
			var ajax = createAjax();
			ajax.open("post","commentown/"+"${videouuid}",true);
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){
			var JsonStr = ajax.responseText;
			var JsonObj = eval("("+JsonStr+")");
			var html = "";
			var html1 = "";
			   $("#ac").html(JsonObj.length);
			var j=3;
			if(JsonObj.length<=j){j=JsonObj.length}
			for(i=0;i<j;i++){
				html +="<li class='comment-d'><div><span style='color: red'>"+
					JsonObj[i].name+"</span><span style='color: green'>"+
					JsonObj[i].time+"</span></div><div><p id='comment-content'>"+
					JsonObj[i].comment+"</p></div></li>";
			}
			for(i=3;i<JsonObj.length;i++){
				html1 +="<li class='comment-d'><div><span style='color: red'>"+
					JsonObj[i].name+"</span><span style='color: green'>"+
					JsonObj[i].time+"</span></div><div><p id='comment-content'>"+
					JsonObj[i].comment+"</p></div></li>";
			} 
			 $("#ul").html(html);
			 $("#ul1").html(html1);
			}
	};
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send();
	} 
	function createAjax() {
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		ajax = new ActiveXObject();	
	}
	return ajax;
}
	
</script>
</head>

<body>
	<div id="mainBody">
		<!-- 评论框 -->
		<div id="top-reply">
			<h1>
				<strong>影评</strong> <span id="top-reply-s">总共<span
					id="ac";style="color: red">0</span>条评论</span>
			</h1>
		</div>
		<!-- 评论输入框  -->
		<form action="commentadd/${videouuid }"
			method="post">
			<div id="commentArea" style="border: 1px solid;">
				<div>
					<textarea id="top-textarea" name="content" placeholder="请输入内容"
						required="required"></textarea>
				</div>
				<!-- 用户登录模块 -->
				<div id="submitbtn">
					<input type="button" class="btn btn-default" value="发表" id="btn">
				</div>
				<br>
			</div>
		</form>
		<!-- 评论显示表  -->
		<div>
			<div>
				<h2>
					<a style="margin-right: 40px"
						onclick="a()">全部评论</a>
					<a id="myComment" onclick="b()">我的评论</a>
				</h2>
			</div>
			<hr>
			<!-- 影评区 -->
			<div>
				<ul id="ul">

				</ul>
				<div id="more">
					<div id="more-1">
						<button id="more-btn" class="btn btn-default">查看更多</button>
					</div>
					<!-- 更多评论 -->
					<div id="more-2" style="display: none;">
						<ul id="ul1">
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
