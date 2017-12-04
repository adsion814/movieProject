<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>视频搜索界面</title>
    <link rel="shortcut icon" href="source/vv.png" type="source/kong.png" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
     <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
  body {
    margin: 0;
    padding: 0;
   
    font: 12px 'Helvetica Neue',Helvetica,Arial,'Microsoft Yahei','Hiragino Sans GB','Heiti SC','WenQuanYi Micro Hei',sans-serif;
   
    color: #222;
    min-width: 990px;
 
}
    
    body {
    background: #fff;
}
#search-wrap {
    width: 100%;
    position: relative;
    margin-top: 39px;
}
#search-wrap #header-search::before{
content: "";
display: table;

} 
 #search-wrap #header-search::after{
 
 clear: both;
 
 }
#search-wrap #header-search::after{
    content: "";
    display: table;
}


#search-wrap #header-search {
    width: 978px;
    height: auto;
    padding-left: 0;
    padding-right: 0;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    position: relative;
}
#search-wrap #header-search .logo-input {
    position: relative;
    height: 43px;
}

.old-ver #search-wrap #header-search #logo {
    display: block;
    left: 198px;
    bottom: 0;
}
#search-wrap #header-search #logo {
    position: absolute;
    left: 135px;
    left: 198px;
    bottom: 0;
}
#search-wrap #header-search #logo {
    background-image: url(../images/sprite-690be8a6ea.png);
    background-position: -261px -72px;
    width: 131px;
    height: 35px;
}
.ir {
    font: 0/0 a;
    text-shadow: none;
    border: 0 none;
    color: transparent;
    _overflow: hidden;
    _font-size: 10px;
    _line-height: 99;
}
.old-ver #search-wrap #header-search #search-block {
    width: 430px;
    bottom: 0px;
    left: 352px;
    right: auto;
}
#search-wrap #header-search #search-block {
    height: 42px;
    width: 562px;
    position: absolute;
    left: 275px;
}
#search-wrap .loupe {
    display: none;
}
.old-ver #search-wrap #header-search #search-block .input-wrap {
    width: 330px;
    margin-right: 10px;
}
#search-wrap #header-search #search-block .input-wrap {
    height: 100%;
    position: relative;
    width: 478px;
    background: #fff;
    border-radius: 4px;
    float: left;
}
input, button, select, textarea {
    outline: 0;
}
input, textarea {
    font: 12px 'Helvetica Neue',Helvetica,Arial,'Microsoft Yahei','Hiragino Sans GB','Heiti SC','WenQuanYi Micro Hei',sans-serif;
}
input[type="text"] {
    color: #222;
    border: 1px solid #ccd0d7;
}
#search-wrap #header-search #search-block .input-wrap input {
    width: 446px;
    border: 0;
    height: 18px;
    box-shadow: none;
    padding: 11px 15px;
    background: transparent;
    border: 1px solid #ccd0d7;
    border-top-left-radius: 4px;
    border-bottom-left-radius: 4px;
}
.old-ver #search-wrap #header-search #search-block .input-wrap input {
    width:330px;
    height:44px;
   
    border: 2px solid #ccd0d7;
    border-radius: 4px;
}
.old-ver .bilibili-suggest {
    width: 327px;
}
.bilibili-suggest {
    border: 1px solid #e5e9ef;
    position: absolute;
    width: 476px;
    border-radius: 4px;
    text-align: center;
    padding: 10px 0;
    color: #222;
    background: #fff;
    z-index: 100;
    overflow: hidden;
}
.bilibili-suggest {
    border: 1px solid #e5e9ef;
    position: absolute;
    background: #fff;
    z-index: 199;
    border-radius: 4px;
    box-shadow: rgba(0,0,0,0.16) 0 2px 4px;
    padding-bottom: 5px;
}
.old-ver #search-wrap #header-search #search-block #search-button {
    width: 90px;
    border-radius: 4px;
}
#search-wrap #header-search #search-block #search-button {
    cursor: pointer;
    float: left;
    width: 84px;
    color: #fff;
    background: #00a1d6;
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
    font-size: 16px;
    letter-spacing: 2px;
    line-height: 42px;
    text-align: center;
}
#search-wrap #header-search #search-block #search-button .icon-search-white {
    vertical-align: middle;
    margin-top: -2px;
}
.icon-search-white {
  
    background-position: -48px 5px;
    width: 25px;
    height: 25px;
}
#search-wrap #header-search #search-block #search-button {
    cursor: pointer;
    color: #fff;
    font-size: 16px;
    letter-spacing: 2px;
    line-height: 42px;
    text-align: center;
}
.so-wrap {
    width: 980px;
    margin: 0 auto;
    overflow: hidden;
    padding-bottom: 10px;
}
h1, h2, h3, h4, h5, h6, ul, li {
    margin: 0;
    padding: 0;
    list-style-type: none;
}
.ajax-render {
    position: relative;
    left: 300px;
    top:50px;
}
.video.list {
    height: 100px;
    width: 808px;
    padding: 20px 0 20px 172px;
    position: relative;
    border-bottom: 1px solid #e5e9ef;
}
a {
    outline: 0;
    color: #00a1d6;
    text-decoration: none;
    cursor: pointer;
}
.synthetical .left-img, .encyclopedia .left-img, .video.matrix .img, .video.list .img, .so-wrap .special > a > .img, .so-wrap .special .video .img, .movie-item .left-img {
    border-radius: 4px;
    position: relative;
}
.video.list .img {
    position: absolute;
    left: 0;
    top: 20px;
    height: 100px;
    width: 160px;
    overflow: hidden;
}

.synthetical .left-img > img, .encyclopedia .left-img > img, .video.matrix .img > img, .video.list .img > img, .so-wrap .special > a > .img > img, .so-wrap .special .video .img > img, .movie-item .left-img > img {
    width: 100%;
    height: 100%;
}
a img {
    border: 0;
}
img {
    border: 0;
    vertical-align: middle;
}
p, span {
    margin: 0;
    padding: 0;
}
.so-imgTag_rb {
    position: absolute;
    right: 0;
    bottom: 0;
    line-height: 18px;
    padding: 0 5px;
    color: #fff;
    background-color: #333;
    background-color: rgba(0, 0, 0, 0.5);
    border-top-left-radius: 4px;
}
.video.list .headline {
    height: 24px;
    font-size: 0;
}
.video.list .type {
    display: inline-block;
    line-height: 23px;
    border-radius: 12px;
    padding: 0 10px;
    border: 1px solid #e5e9ef;
    color: #6d757a;
    text-align: center;
    margin-right: 10px;
    font-size: 12px;
}
.video.list .type.avid {
    display: none;
}
.synthetical .title, .encyclopedia .title, .video.list .title, .so-wrap .special .title, .movie-item .headline .title, .up-item .info-wrap .headline .title {
    font-size: 16px;
    line-height: 16px;
    color: #222;
}
.video.list .title {
    margin-right: 6px;
}
.keyword {
    color: #f25d8e;
}
address, caption, cite, code, dfn, em, i, th, var {
    font-style: normal;
    font-weight: normal;
}
.video.list .des {
    margin-top: 14px;
    width: 762px;
    max-height: 36px;
    overflow: hidden;
}
.synthetical .des, .encyclopedia .des, .encyclopedia .findmore, .video.list .des, .so-wrap .special .des, .so-wrap .special .up-des {
    color: #99a2aa;
    font-size: 12px;
    line-height: 18px;
}
.video.list .tags {
    position: absolute;
    bottom: 20px;
    left: 172px;
}
.video.list .so-icon {
    margin-right: 20px;
}
.so-icon {
    display: inline-block;
    *display: inline;
    *zoom: 1;
    font-size: 12px;
    height: 12px;
    vertical-align: text-top;
    line-height: 12px;
    padding-left: 16px;
    position: relative;
    color: #99a2aa;
}
.so-icon > i {
    position: absolute;
    left: 0;
    top: 0px;
}
.icon-playtime {
    
    background-position: -264px -75px;
    
    width: 14px;
    height: 14px;
}
i {
    display: inline-block;
  
}
address, caption, cite, code, dfn, em, i, th, var {
    font-style: normal;
    font-weight: normal;
}
.video.list .so-icon {
    margin-right: 20px;
}
.icon-subtitle {
    
    background-position: -264px -2px;
    width: 11px;
    height: 11px;
}
.icon-date {
   
    background-position: -193px -122px;
    width: 11px;
    height: 11px;
}
.icon-uper {
   
    background-position: -170px -1;
    width: 11px;
    height: 11px;
}
.so-icon .up-name {
    display: inline-block;
    max-width: 132px;
    height: 16px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.so-icon > a {
    color: #99a2aa;
    cursor: pointer;
}
.video-option{
  float:right;
  position: absolute;
  right: 20px;
  bottom:25px;
}


.paging-wrap {
    width: 924px;
    height: 40px;
    padding-left: 27px;
    padding-right: 27px;
    margin-left: auto;
    margin-right: auto;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
    background: #fff;
    padding-top: 20px;
    padding-bottom: 35px;
}
.pagenum{
  margin-right: 10px;
margin-left: 10px;
border-radius: 4px;

}
.filter-block {
    min-height: 90px;
    width: 978px;
    height: 20px;
    padding-left: 0;
    padding-right: 0;
    margin-left: auto;
    margin-right: auto;
    padding-top: 50px;
    position: relative;
    padding-bottom: -50px;
    background: #fff;
    border-bottom: 1px solid #e5e9ef;
}
.filter-block ul {
margin-left:250px;
    margin-bottom: 10px;
    list-style: none;
    padding: 0;
}

.old-ver .filter-block li.active {
    background-color: #00a1d6;
}
.filter-block li {
    float: left;
    padding-left: 8px;
    padding-right: 8px;
    border-radius: 4px;
    margin-right: 15px;
}
.filter-block li a {
    font-size: 16px;
    color: #6d757a;
    text-decoration: none;
    line-height: 20px;
}
.old-ver .filter-block li.active a {
    color: #fff !important;
}
.old-ver .filter-block li a {
    color: #222;
}
#getform{
 margin-top: 80px;


}
.checkimg{
  width: 100px;
  height: 100px;
  position: absolute;
  margin-left: 550px;
  margin-top: -60px;
  color: red;

}
.vipimg{
  width:30px;
  height: 30px;
  float: right;
  
}
    
    </style>
    <script type="text/javascript">
    var selectedtype;
    function goPage(a,type){
    $("#getCurrentpage").val(a);
    $("#inputform").attr("action","queryvideo/"+selectedtype);
    $("#inputform").submit();
    }
    function inputForm(type){
    $("#inputform").attr("action","queryvideo/"+type);
    selectedtype=type;
    $("#inputform").submit();
    
    }
  
 
    </script>

  </head>
     
  
  <body class="report-wrap-module old-ver">
  <a href="initIndexVideo" class="btn btn-link" style="position:absolute; right:50px;z-index: 100">回到首页</a>
   <div style="height:44px;" class="js-search-wrap">
      
      <div id="search-wrap" >
        <div id="header-search">
          <div class="logo-input">
            <a href="//search.bilibili.com" id="logo" class="search-logo" se-linkid="s-logo">
              <span class="ir" se-linkid='s-btn-top'>bilibili | 搜索</span>
            </a>
            
            <div id="searchcondition">
            
            </div>
            <div id="search-block">
              <i class="loupe" se-linkid='s-btn-loupe'></i>
              <div class="input-wrap">
              <form action="queryvideo" id="inputform" method="post">
           <input type="hidden" name="videopass" id="videopass" value="${queryVideoList.checked}">
           <input type="hidden" name="currentpage" id="getCurrentpage">
           <input type="text" value="${serchkeyword}" id="search-keyword" autocomplete="off" name="keyword">
                </form>
                <div class="bilibili-suggest" style="left:0px;display:none;margin-top:5px">
                <iframe style="position:absolute; left:0px; top:0px;width:100%;height:100%;border:medium;z-index: -1;" border="0" frameborder="no"></iframe>
                
                </div>
                <span><button type="button" class="btn btn-default" onclick="inputForm('default')">按时间排序</button>
                <button type="button" class="btn btn-default" onclick="inputForm('hot')">按热度排序</button></span>
              </div>
      
              <div id="search-button">
                <i class="icon-search-white icon-search icon-white"></i>
                <span><a href="javascript:inputForm('default')" style="color: white;">搜索</a></span>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      </div>
    
    	<ul class="ajax-render" style="width:1100px;">
    	  <c:forEach items="${queryVideoList.listdata}" var="list" varStatus="ite">
			<li class="video list " id="list${ite.count}"> 
				<a href="loadVideo/${list.uuid }"  target="_blank" se-linkid='video_img_1' title="" lnk-type="video">
					<div class="img">
						<img  data-width="320" data-height="200"  src="${list.videopicture}" data-loaded="false" onload="loadImgSucc()" onerror="loadImgErr()">
						<span class="so-imgTag_rb">
							${list.duration}
						</span>  
						
			      <i class="search-watch-later icon-later-off" data-aid="2634507"></i>
					</div>
				</a>
		<c:if test="${list.askVip==1}">	<img alt="##" src="source/vip.png"  class="vipimg"></c:if>
				<div class="info">
					
			     		<div class="headline ">
						<span class="avid type"></span>
						<span class="type hide">${list.type}</span>
						<a class="title"  title="【东方卫视】极限挑战【20150726】" href="//www.bilibili.com/video/av2634507?from=search&amp;seid=9141651883842617988" target="_blank" se-linkid='video_title_1' lnk-type="video">
						   ${list.name}
							<!-- 【东方卫视】<em class="keyword">极限挑战</em>【20150726】 -->
						</a>
					</div>
					<div class="des">
						 ${list.introduction}
					</div>
			
					<div class="tags">
						<span class="so-icon watch-num"  title="观看">
							<i class="icon-playtime icon-play"></i>
				 	  ${list.hot}
						</span>
						<span class="so-icon hide " title="评论">
							<i class="icon-subtitle icon-th-list"></i>
								<c:forEach items="${commentlist}" var="clist">
				     <c:if test="${clist.uuid==list.uuid}">${clist.count}</c:if>
						 </c:forEach>
				
						</span>
						<span class="so-icon time" title="上传时间">
							<i class="icon-date icon-calendar"></i>
							${list.uploadTime}
						</span>
					
						<span class="so-icon" title="up主">
							<i class="icon-uper icon-user"></i>
							<a class="up-name" target="_blank" se-linkid="video_1_2634507_up">${list.uploadUser}</a>
						</span>
					</div>
		

				</div>
			
		
  <input type="hidden" name="videouuid" value="${list.uuid}" id="videouuid${ite.count}">
			 
			 <div id="foo${ite.count}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">

  
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    <button class="btn btn-danger"  onclick="toDeleteVideo('list${ite.count}','videouuid${ite.count}');" data-dismiss="modal" >确认</button>
    
  </div>
 
</div>



  <div id="myModal${ite.count}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">视频审核</h3>
  </div>
  
  <div class="modal-body">
 
     <select  style="margin-left: 120px;" id="selectcheck${ite.count}">
       <option value="1">审核通过</option>
       <option value="2">审核未通过</option>
     </select>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    <button class="btn btn-primary"  onclick="videoUpdate('videouuid${ite.count}','selectcheck${ite.count}' ,'labelforcheck${ite.count}');" data-dismiss="modal" >保存修改</button>
    
  </div>
 
</div>

			 </li>
			</c:forEach>
			</div>
			
 <c:if test="${empty queryVideoList.listdata}">
 <img alt="##"  src="source/kong.png" style="margin-left: 400px;">
  
  
  </c:if>
			
		





   <form action="queryvideo" method="post" id="getform">
   <div class="pagination pagination-large" style="text-align: center">
   <input type="hidden" name="currentpage" value="${queryVideoList.currentpage}" id="getCurrentpage">
      <ul>
        <c:if test="${queryVideoList.currentpage ne 1}">
        <li><a href="javascript:goPage(${queryVideoList.prepage})">上一页</a></li>
        </c:if>
        <c:if test="${queryVideoList.currentpage ne queryVideoList.totalpage}">
         <c:forEach begin="${queryVideoList.index.beginIndex}" end="${queryVideoList.index.endIndex}" var="index">
        
       <li><a href="javascript:goPage(${index})" class="pagenum active" style="background-color:${queryVideoList.currentpage==index ?'#49afcd':''};color:${queryVideoList.currentpage==index ?'white':''}">${index}</a></li>
         </c:forEach>
       
       
        
        <li><a href="javascript:goPage(${queryVideoList.nextpage})">下一页</a></li>
        </c:if>
         
      </ul>
   </div>
    </form>
			
			<c:if test="${user.identity ne 0 }"></c:if>
  </body>
</html>
