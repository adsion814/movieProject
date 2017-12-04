<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.mp.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>视频播放</title>
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
		
	
		
			
			 <link href="http://vjs.zencdn.net/5.8.8/video-js.css" rel="stylesheet">
			 <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>
 <link rel="stylesheet" type="text/css" href="css/video/danmuplayer.css">
			<script src="js/video/danmuplayer.js"></script>
			 <link rel="stylesheet" type="text/css" href="css/video/videostyle.css">
			 		<script src="js/video/videofunction.js"></script>
		  

		
	
	

 </head>
 <body>
 

  
 
   <div class="input-group"  >
                    <input type="text" class="form-control" style="background-color: transparent;">
                    <span class="input-group-btn " >
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
                </div>
                <div id="guidehead">
		   <span>
		   <a class="btn btn-link" href="index.jsp">回到首页</a>
		   <a id="upload" class="btn btn-link" href="uploadVideo">上传</a> 
		   <a id="register" class="btn btn-link" href="Register.jsp">注册</a>
		   <a id="login" class="btn btn-link" href="Login.jsp">登陆</a>
		   <a id="vip" class="btn btn-link" href="pay">成为vip</a>
		  <a id="mg" href="manageMyInfo"><img style="width:50px;height:50px;" class="img-circle" src="${user.picture }"/></a></span>	
			</div>
<div id="danmup">

</div> 
<div style="margin:35px;"> <h1 style="font-size: 30px">${video.name} 视频简介 </h1>
<p> ${video.introduction }</p>
</div>


<%-- 
<c:import url="comment.jsp"></c:import> --%>
<jsp:include page="comment.jsp"></jsp:include>
<c:set value="${video.uuid }" var="videouuid"></c:set>
</body>


 <script type="text/javascript">
 var time1;
 var isFirstLoad=true;

		$("#danmup").DanmuPlayer({
			src : "${video.address}", //视频源 
			height : "480px", //区域的高度 
			width : "800px", //区域的宽度 
		 urlToGetDanmu:"danmuGet/${video.uuid}",     //从后端获取弹幕数据 
		 urlToPostDanmu:"danmuPost/${video.uuid}"  //发送弹幕数据给后端保存入库 
		 

		});
		
		function send(info){
			console.debug("send");
			var videouuid="${video.uuid}"
				var useruuid="${user.uuid}"
				var time=document.getElementById("danmuvideoplay").currentTime;
			console.debug(time);
				var info = '{ "videouuid":"' + videouuid + '","useruuid":"' + useruuid + 
					'","time":' + time + "}";
	            
			
			$.ajax({
				type:"post",
				url:"saveProcess",
				contentType:"application/json;charset=utf-8",
				data:info,
				dataType:"json"
				
			
			
				});
		}
		<c:if test="${!empty user}">
		$(".danmu-video").on("play",function(){
		console.debug("play");
		
				time1=setInterval("send()",5000);
			
			
		});
		</c:if>
		
		$(".danmu-video").on("pause",function(){
			
			window.clearInterval(time1);
		});
         if(isFirstLoad){
		        	 console.debug("Get");
		        		var videouuid="${video.uuid}"
		    				var useruuid="${user.uuid}"
		    				var time=document.getElementById("danmuvideoplay").currentTime;
		    			
		    				var info = '{ "videouuid":"' + videouuid + '","useruuid":"' + useruuid + 
		    					'","time":' + time + "}";
		        	 $.ajax({
		        		 type:"post",
		        		 url:"getProcess",
		        		 contentType:"application/json;charset=utf-8",
		        			data:info,
		        			dataType:"json",
		        			success:function(data){
		        				console.debug("success");
		        				if(data>0){
		        					document.getElementById("danmuvideoplay").currentTime=data;
		        				}
		        			}
		        	 });
		        	 isFirstLoad=false;
		         }
	</script>
 <c:if test="${empty user }">
 <script type="text/javascript">


 $(".opt-btn.ctrl-btn ").hide();
 $(".danmu-input.ctrl-btn").hide(); 
 $(".send-btn.ctrl-btn").hide();
 $("#vip").hide();
 $("#upload").hide();
$("#btn").attr("disabled","disabled");
$("#btn").attr("value","请先登陆");
$("#myComment").hide();
$("#mg").hide();
 </script>
 </c:if>
 <c:if test="${!empty user }">
<script type="text/javascript">
$("#upload").show();
$("#register").hide();
$("#login").text("退出");
$("#login").attr("href","loginOut"); 
$("#vip").show();

</script>
</c:if>
 <c:if test="${user.identity ne 1 }">
 <script type="text/javascript">
 $(".opt-btn.ctrl-btn ").hide(); 


 </script>
 </c:if>
 <c:if test="${user.identity eq 1}">
<script type="text/javascript">
$("#vip").text("VIP");
$("#vip").css({"href":"#","color":"red"});
$("#vip").removeAttr("href");
</script>

</c:if>
</html>