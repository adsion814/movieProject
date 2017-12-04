<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" href="source/vv.png" type="source/kong.png" />
    <title>上传界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/jquery.fs.tipper.css" rel="stylesheet" media="screen">
     <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.fs.tipper.js"></script>
    <script type="text/javascript">
var falseNum = 0;  
$(document).ready(function(){
    $("#errortip1").html(" ");
    $(".tipped").tipper();



    $("#subbut1").bind('click',function(){
    	var str=$("[name=file]").val();
    	var n=str.search("[/s/S]*[.][mM][pP][4]");
    
     if($("[name=file]").val()==""||$("[name=file]").val()==null){
            $("#errortip1").html("未选择文件");
           
              return;
        
            }
     else if(n<0){
    	 $("#errortip1").html("文件格式必须是mp4");
    	
         return;
     }
     else {
            $("#errortip1").html(" ");
            $('#subbut').bind('click',  
                    function(){
                  
                    if($("[name=file]").val()==""||$("[name=file]").val()==null){
                    $("#errortip1").html("未选择文件");
                      return;
                
                    }else {
                    $("#errortip1").html("");
                    
                    }
                    
                    if($("[name=videotitle]").val()==""||$("[name=videotitle]").val()==null){
                    $("#errortip2").html("标题不能为空");
                      return;
                   
                    }else {
                    $("#errortip2").html("");
                        $("#fForm").submit();
                    var eventFun = function(){  
                        $.ajax({  
                            type: "GET",  
                            url: "UploadFileProgressServlet",  
                            data: {},  
                            dataType: 'text',  
                            success : function(resData){  
                                
                                if(falseNum > 10){  
                                  window.clearInterval(intId);  
                                  return;  
                                }  
                                var obj = eval("("+resData+")");  
                                if(obj.data == 'NoData'){  
                                   falseNum ++ ;  
                                   return;  
                                }  
                                $("#graphbox").css('display','block');  
                                $(".bar").css('width',obj.uploadPrecent+'%');  
                                $("#uploadPer").html(obj.uploadPrecent+'%');  
                                $("#progressInfo").html('总大小：'+obj.totalSize  
                                        +'，速度：'+obj.uploadSpeed  
                                        +'%，剩余时间：'+obj.remainTime+'，已用时间：'+obj.useTime);
                                 $("#title").html("当前上传:"+getFileName($("[name=file]").val()));  
                                if(obj.uploadPrecent == 100){  
                                    window.clearInterval(intId);  
                                   
                                    $("#progressInfo").html("<h4>上传成功!</h4>");  
                                    $("#subbut").attr("disabled","disabled");
                                   
                                    <c:if test="${user.identity eq 0}">
                                    setTimeout(function(){window.location.href="adminManage";},3000);
                                    </c:if>
                                    <c:if test="${user.identity ne 0}">
                                    setTimeout(function(){window.location.href="initIndexVideo";},3000);
                                    </c:if>
                                }     
                    }});};  
                    var intId = window.setInterval(eventFun,500);  
                    }
                    
                
            });
            }
  
    
    });   
       
       
    
}); 

function getFileName(o){
    var pos=o.lastIndexOf("\\");
    return o.substring(pos+1);  
}
$(function(){

$(".file").on("change","input[type='file']",function(){
var filePath=$(this).val();
console.debug(filePath);
$("#filename").html(filePath);

});
});
</script>
 <style type="text/css">


 ul {
	list-style: none;
}
.pl20 {
    padding-left: 20px;
    color: red;
}
.commonpro{
margin-top: 50px;
margin-left: 400px;

}
.itemsname{
margin-left: -50px;
float: left;


}
.redflower{
color: red;
display: inline-block; 
margin-left: 20px;


}
.errmsg{
color: red;

}

.file {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
.file input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.file:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
}

 </style>
  </head>
  <body>
      <div id="graphbox" style="display: none;text-align: center">
         
           <h3 id="title"></h3>
          <div class="progress progress-striped active" style="width: 1000px;margin-left: 200px;">
          <div class="bar" style="width: 0%;"></div>
          
          </div>
          <span id="progressInfo"></span>
      </div>
       <div class="mainContent" >
         <iframe name="uploadf" style="display:none"></iframe> 
      <form action="UploadFileServlet" encType="multipart/form-data" method="post" id='fForm' target="uploadf">
        <div class="control-group commonpro" >
         <i class="redflower" style="margin-left: 20px;margin-top: 5px;">*</i> <a href="javascript:;" class="file" style="margin-top: 20px;">点击选择视频
         <input type="file" name="file" id="fileName" value="" >
           </a>
            <input type="button" id="subbut1" value="视频校验" class="btn btn-danger" style="margin-bottom: 20px;margin-left: 0px;">
         <span id="filename"></span>
    
      </div>
       <span class="errmsg" id="errortip1" style="margin-left: 420px;"></span>
       <div class="control-group commonpro">
        <label class="control-label itemsname" >标题</label>
        <div class="controls">
        <i class="redflower">*</i>
          <input type="text"  placeholder="给上传的视频取个名字吧。。" style="height: 30px; position: absolute; margin-left: 7px;" class="input-xxlarge" name="videotitle">
        </div>
        
      </div>
      <span class="errmsg" id="errortip2" style="margin-left: 420px;"></span>
      
      <div class="control-group commonpro">
        <label class="control-label itemsname" >分类</label>
        <div class="controls">
         <i class="redflower">*</i>
          <select style="position: absolute;margin-left: 7px;" name="videotype">
          <option value="科幻">科幻</option>
          <option value="恐怖">恐怖</option>
          <option value="言情">言情</option>
          <option value="其他">其他</option>
          
          </select>
        </div>
      </div>
     
      
    <c:if test="${sessionScope.user.identity==0}">
     <div class="control-group commonpro">
        <label class="control-label itemsname" >是否为会员观看</label>
        <div class="controls">
        <i class="redflower">*</i>
          <input type="radio" name="askvip" style="margin: auto 7px;" value="0">是
           <input type="radio" name="askvip" style="margin: auto 7px;" value="1">否
        </div>
      </div>
      </c:if>
      
      <div class="control-group commonpro">
       <label class="control-label itemsname">描述</label>
        <div class="controls">
         <textarea rows="10" style="width: 500px; margin-left: 30px; position: absolute;" placeholder="描述是对视频内容的详细说明，不少于10个字，并且不要和标题一样"  name="videodescript"></textarea>
          <div class="controls">
           </div>
          
        </div>
      </div>
     <div style="position: absolute; margin-top:250px; margin-left: 600px"><input  alt="校验后可上传" type="button" class="btn commonpro btn-info button tipped"  data-title="校验后可上传" data-tipper-options='{"direction":"top"}' value="上传" id="subbut" style="margin-left: 50%; margin-top: 15px;"></div>
      </form>
       </div>
        
<c:if test="${msg==1}">
<script type="text/javascript">
$(function(){
$("#myModal").modal('show');
});
</script>
</c:if>


    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">信息</h3>
  </div>
  <div class="modal-body">
    <h4 style="margin-left: 220px;">保存成功</h4>
  </div>
  <div class="modal-footer">
    
    <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >确认</button>
  </div>
</div>
   
  </body>
</html>
