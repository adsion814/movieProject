<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息管理</title>
    <link rel="shortcut icon" href="source/vv.png" type="source/kong.png" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Custom.css">
<!-- 	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 -->
 	<style type="text/css">
 	 	/*第一部分*/

#D1{
	display: block;
	height: 150px;
	width: 100%;
}
h1{	
	display: inline-block;
	border: solid;
	border-color: aquamarine;
	border-radius:2em;
	text-align: center;
	height: 50px;
	width: 300px;
	display: inline-block;
	background-color: deepskyblue;
	color: white;
}
#H1{
	display: inline-block;
	width: 800px;
	text-align: right;
}
a{
	text-decoration: none;
}

/*第二部分*/


#D2{
	display: block;
	text-align: center;
	height: 500px;
	background: url(img/img7.jpg)no-repeat;
}

.ul1{	
	text-align: left;
	display: inline-block;
	position: relative;left: 250px;bottom: 10px;
	border: solid;
	border-color: silver;
	border-width: 3px;
	height: 300px;
	border-radius: 2em;
	padding: 10px;
	box-shadow: 10px 10px 5px darkgray;
	background-color: rgba(150,150,150,0.5);
}

li{
	display: inline-block;
	height: 20px;
	margin: 15px;
}
#p1:HOVER{
	#D2{background: url(img/img5.jpg)no-repeat;}
}
.L1{
	width: 100px;
	font-family: monospace;
	color: white;
}
.L2{
	text-align: center;
}
#B1{
	text-align: center;
	height: 40px;
	width: 300px;
	background-color: #00BFFF;
	color: white;
	border-style: none
	cursor: pointer;
}

/*第三部分*/

#D3{
}
h2{
	margin: 15px;
}

 	</style>	
 	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
	</script>
	<script>
	   $(function(){
		$("#T3").blur(function(){
		 if($("#T3").val()!=$("#T2").val()){
			 $("#tipId").html("不一样啦");
			}else{
			 $("#tipId").html("可以啦"); 
			}
		});
	});
/* 	function cmi(){
			if($("#T3").val()!=$("#T2").val()){
				alert("请重新确认密码");
				window.location.href=Custom.jsp;
			}else{
				console.log("OKKKK");
			}
		} */
	</script>
  </head>
  
	<body>
	<div id="D1">
	<h1>个人中心</h1>
	<h4 id="H1"><a href="/movieProject/index.jsp">首&nbsp;&nbsp;页</a>|<a href="/movieProject/videoSearch.jsp">搜&nbsp;&nbsp;索</a>|欢迎你,${user.name}</h4>
	<hr />
	</div>
	<div id="D2">
	<form action="custom" method="post" id="f1" enctype="multipart/form-data" encoding="multipart/form-data">
	<ul class="ul1">
	<li class="L1">昵称：</li><li><input type="text" id="T1" name="nickname"></li><br />
    <li class="L1">密码：</li><li><input type="password" id="T2" name="password"></li><br />
    <li class="L1">确认密码：</li><li><input type="password" id="T3"><span id="tipId"></span></li><br />
    <li class="L1">头像：</li><li><input type="file" name="headimg" id="T4"></li><br />
    <li class="L1"><input type="submit" id="B1" value="确认修改" ></li><br />
    </ul>
    </form>
    <hr style="height: 3px" />
    </div>
    <div id="D3">
    <hr>

    	<a href="queryvideo/uploadUser"><h2 style="display: inline-block">我的视频</h2></a>

    </div>
	</body>
</html>
