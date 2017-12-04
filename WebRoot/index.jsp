<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="com.mp.bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>
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
    <script type="text/javascript" src="js/indexfunction.js"></script>
	<link rel="stylesheet" type="text/css" href="css/indexstyles.css">
	

</head>
<script type="text/javascript">
function gotosearch(){

	$("#iform").attr("action","queryvideo/default");
	$("#iform").submit();
}
</script>
<style>
a{
text-decoration: none;
}
</style>

<body>

<div class="container">

    <form class="bs-example bs-example-form" style="position: absolute;" action="" id="iform">
        <div class="row">
   
            <div class="col-lg-6">
            
                <div class="input-group" style="width: 300px; left:400px;" >
                    <input type="text" name="keyword" class="form-control" id="searchcondition" style="background-color: rgba(255,255,255,0.5);">
                    <span class="input-group-btn " >
                        <button class="btn btn-default" type="button" onclick="gotosearch()">搜索</button>
                    </span>
                </div>
            </div>
        </div>
    </form>

	<div class="row">
		<div class="span12">
			<div id="carousel-617528" class="carousel slide">
			<div id="guidehead">
		   <span><a id="upload" class="btn btn-link" href="uploadVideo">上传</a> <a id="register" class="btn btn-link" href="Register.jsp">注册</a><a id="login" class="btn btn-link" href="Login.jsp">登陆</a><a id="vip" class="btn btn-link" href="pay">成为vip</a><a id="mg" href="manageMyInfo"><img id="mimg" style="width:50px;height:50px;" class="img-circle" src="${user.picture }"/></a></span>	
			</div>
				<div id="indexlist">
				<ul>
				<li id="slideone"><h4 id="moviehead1"><a href="loadVideo/32dfdf74-ee4e-420d-b8f3-ae15426ef743">土之魔王兽出场</a></h4><p><a >最强的矛与最强的盾</a></p></li>
				<li id="slidetwo"><h4 id="moviehead2"><a href="loadVideo/fb67a546-dc3a-4a75-bf5e-faf65a4808b4">未知巨人?预告</a></h4><p><a>出手太重,连自己人都打</a></p></li>
				<li id="slidethree"><h4 id="moviehead3"><a href="loadVideo/e4b11042-06a6-4dcb-abcd-0565b2596221">重光形态</a></h4><p><a>第一次变身</a></p></li>
				</ul>
				</div>
				<div class="carousel-inner">
					<div class="item active" style="background-repeat:no-repeat; background: url('img/1.jpg') no-repeat;background-size:cover; width:100%;height:600px;">
					
					
					</div>
					<div class="item" style="background-repeat:no-repeat;background: url('img/2.jpg') no-repeat;background-size:cover; width:100%;height:600px;">
						
					
					</div>
					<div class="item" style="background: url('img/3.jpg' ) no-repeat  ;background-size:cover; width:100%;height:600px;">
				
					
					</div>
				</div> 

			</div>
		</div>
	</div>
</div>
<c:if test="${empty videoList }">

<c:redirect url="initIndexVideo"></c:redirect>
</c:if>


<div style="margin: auto; text-align: center;height: 200px; witdh:100%;"  class="videoinfo" >
<h1>科幻</h1>
<span>

<c:forEach items="${videoList }" var="video">

<c:if test="${video.type eq '科幻' }">
<div  style="float: left; margin: 25px;">
<a href="loadVideo/${video.uuid }"><img  src="${video.videopicture }"> </a>
<br>
${video.name }
</div>
</c:if>
</c:forEach>
 </span>
</div>
<div style="margin: auto; text-align: center; height: 200px; witdh:100%;"  class="videoinfo">
<h1>恐怖</h1>
<span style="text-align: center;">

<c:forEach items="${videoList }" var="video">
<c:if test="${video.type eq '恐怖' }">

<div style="float: left; margin: 25px">
<a href="loadVideo/${video.uuid }"><img  src="${video.videopicture }"> </a>
<br>
${video.name }
</div>
</c:if>
</c:forEach>
</span>
</div>
<div style="margin: auto; text-align: center; height: 200px; witdh:100%;"  class="videoinfo">
<h1>言情</h1>

<span>

<c:forEach items="${videoList }" var="video">
<c:if test="${video.type eq '言情' }">
<div style="float: left; margin: 25px">
<a href="loadVideo/${video.uuid }"><img  src="${video.videopicture }"> </a>
<br>
${video.name }
</div>
</c:if>
</c:forEach>
 </span>
</div>


<c:if test="${empty user }">
<script type="text/javascript">
$("#upload").hide();
$("#vip").hide();
$("#mg").hide();
</script>
</c:if>
<c:if test="${!empty message }">
<script type="text/javascript">alert("${message}")</script>
<c:remove var="message"/>
</c:if>
<c:if test="${!empty errorMessage }">
<script type="text/javascript">alert("${errorMessage}")</script>
<c:remove var="errorMessage"/>
</c:if>

<c:if test="${!empty user }">
<script type="text/javascript">
console.debug("${user}")
$("#upload").show();
$("#vip").show();
$("#register").hide();
$("#login").text("退出");
$("#login").attr("href","loginOut"); 
$("#mg").show();
</script>
</c:if>
<c:if test="${user.identity eq 1}">
<script type="text/javascript">
$("#vip").text("VIP");
$("#vip").css({"href":"#","color":"red"});
$("#vip").removeAttr("href");
</script>

</c:if>

</body>

</html>
