<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'videouploadbyadmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
     <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
var falseNum = 0;  
$(document).ready(function(){
    $('#subbut').bind('click',  
            function(){
            if($("[name=file]").val()==""||$("[name=file]").val()==null){
            $(".errmsg").html("未选择文件");
              return;
            
            }
            
                $('#fForm').submit();  
                var eventFun = function(){  
                    $.ajax({  
                        type: "GET",  
                        url: '/videoproject/UploadFileProgressServlet',  
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
                               
                                $("#progressInfo").html("上传成功！       <a href='javascript:toDeleteVideo();' ><i class='redflower'>x  </i>点此取消上传</a>");  
                            }     
                }});};  
                var intId = window.setInterval(eventFun,500);  
    });  
}); 
function toDeleteVideo(){
console.debug(666666);
   $.get("/videoproject/adminremovevideo",function(data,status){
   console.debug(data);
        if(data=="true"){
        $("#graphbox").css('display','none');  
        $("[name=file]").val("");
        }else{
         alert("删除失败");
        
        }
        
   });
}
function getFileName(o){
    var pos=o.lastIndexOf("\\");
    return o.substring(pos+1);  
}
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


}
.itemsname{
margin-left: 300px;



}
.redflower{
color: red;
display: inline-block; 
margin-left: 20px;


}
.errmsg{
color: red;

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
      <form action="/videoproject/UploadFileServlet" encType="multipart/form-data" method="post" id='fForm' target="uploadf">
     
       <div style=""><input type="file" name="file" value="" >
       <input type="button" id="subbut" value="点此上传视频">
       <span class="errmsg"></span>
       </div>
       </form>
        <iframe name="uploadf" style="display:none"></iframe> 
         <form class="form-horizontal" method="post" action="/videoproject/addvideobyadmin">
      <div class="control-group commonpro">
        <label class="control-label itemsname" >标题</label>
        <div class="controls">
        <i class="redflower">*</i>
          <input type="text"  placeholder="给上传的视频取个名字吧。。" style="height: 30px; position: absolute; margin-left: 7px;" class="input-xxlarge" name="videotitle">
        </div>
      </div>
      <div class="control-group commonpro">
        <label class="control-label itemsname" >分类</label>
        <div class="controls">
         <i class="redflower">*</i>
          <select style="position: absolute;margin-left: 7px;" name="videotype">
          <option value="综合">综合</option>
          <option value="综艺">综艺</option>
          
          </select>
        </div>
      </div>
      <div class="control-group commonpro">
       <label class="control-label itemsname">描述</label>
        <div class="controls">
         
         
         <textarea rows="10" style="width: 500px; margin-left: 30px; position: absolute;" placeholder="描述是对视频内容的详细说明，不少于10个字，并且不要和标题一样"  name="videodescript"></textarea>
          <div class="controls">
           </div>
          
        </div>
      </div>
       <div style="position: absolute; margin-top: 200px; margin-left: 600px"><input type="submit" class="btn commonpro btn-info" value="保存" style="margin-left: 50%; margin-top: 15px;"></div>
    </form>
    </div>
  </body>
</html>
