package com.mp.tools;
import java.util.List;


public class FFmpeg {
	 public static boolean Capture(String toolpath,String videoLocation,String timeStart,String frames,String despath)    
	   {    
	        List<String> commend = new java.util.ArrayList<String>();    
	        commend.add(toolpath);    
	        commend.add("-ss");   
	        commend.add(timeStart);    
	        commend.add("-i");    
	        commend.add(videoLocation);    
	        commend.add("-y");    
	        commend.add("-f");    
	        commend.add("image2");    
	        commend.add("-vframes");    
	        commend.add(frames);    
	        commend.add(despath+".jpg"); 
	        System.out.println(despath+".jpg");
	        try {    
	            ProcessBuilder builder = new ProcessBuilder();    
	            builder.command(commend);    
	            builder.start();    
	            return true;    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	            return false;    
	        }    
	   }    
	   public static void main(String[] args){  
	       boolean flag = Capture("D:/java/java2/videoproject/WebRoot/res/ffmpeg.exe","D:/OpenSources/Tomcat7/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/videoproject/video/爱剪辑-我的视频.mp4","15","1","D:/OpenSources/Tomcat7/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/videoproject/picture/1324");  
	       if(flag != false)  
	       {  
	           System.out.println("视频截图成功！！！");  
	       }  
	   }  

}
