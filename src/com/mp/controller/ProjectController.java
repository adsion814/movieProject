package com.mp.controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.mp.bean.*;
import com.mp.service.ProjectService;
import com.mp.tools.*;


@Controller
public class ProjectController {
	
	
  @Autowired
  private ProjectService projectService;
  
  

@RequestMapping(value="/initIndexVideo")
public void initIndexVideo(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("videoList",projectService.getAllVideo());
	req.getRequestDispatcher("/index.jsp").forward(req, resp); 
}
  
  @RequestMapping(value="loadVideo/{videouuid}")
  public String loadVideo(@PathVariable("videouuid") String uuid,HttpServletRequest req) {
	
	  Video video=projectService.getVideoByUuid(uuid);
	  String str=video.getAddress();
	  System.out.println(str);
	  str=str.substring(str.lastIndexOf("\\")+1,str.length());
	  str="videosource/"+str;
	  long num=video.getHot();
	  
	video.setHot(num++);
	projectService.addHot(video);
	video.setAddress(str);
req.setAttribute("video", video);

	  return "video.jsp";
	 
  }
  @RequestMapping(value="/checkreg")
  public String checkregister(HttpServletRequest req,HttpServletResponse resp) throws Exception{
	  	String email = req.getParameter("email");
	  	UserDao dao = new UserDao();
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		User ui;
		try {
			ui = dao.query(email);
			if(ui!=null){
				out.write("邮箱已注册");
			}else{
				out.write("可以注册");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/Register.jsp";
  }
  @RequestMapping(value="/register")
  public String register(HttpServletRequest req,HttpServletResponse resp) throws Exception{
  	  	String uuid = UUID.randomUUID().toString();
  		String email = req.getParameter("email");
  		String password = req.getParameter("password");
  		String name = req.getParameter("nickname");
  		
  		UserDao dao = new UserDao();
  		boolean flag = false;
  		
 
  	
  			try {
  
					User ui = new User(uuid,email,password,2,name,null);
  				flag = dao.addUser(ui);
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  				req.getSession().setAttribute("errorMessage", "用户名重名");
  				return"redirect:/index.jsp";
  			}
  		
  		if(flag){  
  			return"redirect:/index.jsp";
  			
  			
  		}else{  
  			
  		}
		return "redirect:/Register.jsp";
  	}
  @RequestMapping(value="/randomCode")
  public void randomCode(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//生成随机数
		String randomCode = UUID.randomUUID().toString().substring(0, 5);

		//把随机数放进Session中
		req.getSession().setAttribute("RANDOMCODE_IN_SESSION", randomCode);

		//创建图片对象
		int width = 80;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);

		//画板
		Graphics g = image.getGraphics();
		g.setColor(Color.YELLOW);
		//绘制一个实心的矩形
		g.fillRect(1, 1, width - 2, height - 2);

		//把随机数画进图片中
		g.setColor(Color.BLACK);//设置随机数的颜色
		Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
		g.setFont(font);//设置随机数的字体和大小
		g.drawString(randomCode, 10, 28);
		//干扰线
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}

		//关闭
		g.dispose();
		//把图片对象以流的方式保存出去
		ImageIO.write(image, "jpg", resp.getOutputStream());
  }

  @RequestMapping(value="/checkyzm")
  @ResponseBody
  public String checkyzm(HttpSession session,@RequestParam String randomCode) {
	 String sessionRandomCode= (String) session.getAttribute("RANDOMCODE_IN_SESSION");
	 

	  if(!StringUtils.hasLength(randomCode) || !StringUtils.hasLength(sessionRandomCode) ||!randomCode.equals(sessionRandomCode)){
		
		return "验证码错误";
			
		}
	
	  return "验证码正确";
  }
  @RequestMapping(value="/Login")
  public String login(@RequestParam("email")String email,@RequestParam("password") String password,HttpSession session) throws Exception{

  	  	UserDao dao = new UserDao();
		
		User ui = dao.checkLogin(email,password);

		if (ui == null) {

		session.setAttribute("errorMessage", "帐号或者密码错误");
			return "redirect:/Login.jsp";

		} 
		else if(ui.getUuid().equals("admin")) {
			session.setAttribute("user", ui);
			return "videoManage.jsp";
			
		}
		else {
			  String str=ui.getPicture();
			  str=str.substring(str.lastIndexOf("\\")+1,str.length());
			  System.out.println(str);
			  str="img/"+str;
			  System.out.println(str);
			  ui.setPicture(str);
			session.setAttribute("user", ui);

		}


		return "redirect:/index.jsp";
  	}
  @RequestMapping(value="/custom")
  public String custom(@RequestParam(value="headimg",required=false)CommonsMultipartFile file,
		  @RequestParam(value="nickname",required=false)String name,
		  @RequestParam(value="password",required=false)String password,
		  HttpSession session
		  ) throws IllegalStateException, IOException{
	  

			

					User user=(User) session.getAttribute("user");
			
					if(name!=null&&!name.equals(""))
					user.setName(name);
					if(password!=null&&!password.equals(""))
					user.setPassword(password);
					if(file.getOriginalFilename()!=null&&!file.getOriginalFilename().equals(""))
					{
						File filepath=new File("E:/eclipsework/movieProject/WebRoot/img/"+user.getUuid()+file.getOriginalFilename());
						file.transferTo(filepath);
						user.setPicture(filepath.getAbsolutePath());
					}
					
					projectService.updataUserInfo(user);
				String str=user.getPicture();
					  str=str.substring(str.lastIndexOf("\\")+1,str.length());
					  str="img/"+str;
					  user.setPicture(str);
					  System.out.println(str);
					session.setAttribute("user", user);

session.setAttribute("message", "修改成功");
	return "redirect:/initIndexVideo";
  }
  
 @RequestMapping(value="/Userqueryvideo")
 public String QueryVideo(HttpServletRequest req, HttpServletResponse resp){
	 Integer videopass =-1;//check标志
	
		String currentpageStr = req.getParameter("currentpage");
		User user=(User) req.getSession().getAttribute("user");
		String uploadUser = user.getName();
		String videopassStr = req.getParameter("videopass");
		VideoInfoDao vdao = new VideoInfoDao();
		ProductQueryObject op = new ProductQueryObject();
		op.setUploaduser(uploadUser);
		
		try {
			if(StringUtils.hasLength(currentpageStr)){
				Integer currentpage = Integer.valueOf(currentpageStr);
				op.setCurrentpage(currentpage);
				
			}
			if(StringUtils.hasLength(videopassStr)){
				 videopass = Integer.valueOf(videopassStr);
				
			}
			op.setChecked(videopass);
			
			PageResult queryVideoList = vdao.queryVideoList(op,"default");
			List<Video> listdata = queryVideoList.getListdata();
			req.setAttribute("serchuploadUser", uploadUser);
			req.setAttribute("queryVideoList", queryVideoList);

		
			return "MyVideo.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MyVideo.jsp";	
		
 }
 
 
 @RequestMapping(value="/pay")
  public String pay() {
	  return "pay/index.jsp";
  }
  @RequestMapping(value="/payState")
  @ResponseBody
  public String paySuccess(HttpServletRequest request,@RequestParam("out_trade_no")String out_trade_no
  ,@RequestParam("trade_no")String trade_no,@RequestParam("trade_status")String trade_status
		  ) throws AlipayApiException, UnsupportedEncodingException {
	  Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
	
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		if(signVerified) {//验证成功
			//商户订单号 out_trade_no
			
		
			//支付宝交易号 trade_no
		
		
			//交易状态 trade_status
			
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}
		 
		
	
			return "success";
			
		}else {//验证失败

			return "fail";
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
  }
  @RequestMapping(value="/payResult")
  public String payResult(HttpServletRequest request,HttpServletResponse response,@RequestParam("out_trade_no")String out_trade_no
		  ,@RequestParam("trade_no")String trade_no) throws AlipayApiException, ServletException, IOException {
	  Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			
			request.getSession().setAttribute("message", "支付成功");
			User user=(User) request.getSession().getAttribute("user");
			projectService.setVip(user);
			request.getSession().setAttribute("user", projectService.getUserByUuid(user.getUuid()));
		
		
		}else {
			request.getSession().setAttribute("message", "支付失败");
			
		}
		return "redirect:/index.jsp";
	  
  }
  @RequestMapping(value="/gotoPay")
  public String gotoPay() {
	  return "pay/alipay.trade.page.pay.jsp";
  }

  @RequestMapping(value="/loginOut")
  public String loginOut(HttpSession session) {
	  session.removeAttribute("user");
	  return "redirect:/index.jsp";
  }

  @RequestMapping(value="/queryvideo/{condition}")
  public String QueryVideoByAdminServlet(HttpServletRequest req, HttpServletResponse resp,@PathVariable("condition")String condition) throws Exception, IOException{
	  Integer videopass =-1;//check标志
		
		String currentpageStr = req.getParameter("currentpage");
		String keyword = req.getParameter("keyword");
		String videopassStr = req.getParameter("videopass");
		VideoInfoDao vdao = new VideoInfoDao();
		VideoCommentDao cdao = new VideoCommentDao();
		ProductQueryObject op = new ProductQueryObject();
	User user=	(User) req.getSession().getAttribute("user");
		op.setName(keyword);
	   if(condition.equals("uploadUser")) {
		   op.setUploaduser(user.getName());
	   }
		
		try {
			if(StringUtils.hasLength(currentpageStr)){
				Integer currentpage = Integer.valueOf(currentpageStr);
				op.setCurrentpage(currentpage);
				
			}
			if(StringUtils.hasLength(videopassStr)){
				 videopass = Integer.valueOf(videopassStr);
				
			}
			op.setChecked(videopass);
			
			PageResult queryVideoList = vdao.queryVideoList(op,condition);
			List<Video> listdata = queryVideoList.getListdata();
			List<CommentCount> l=new ArrayList<CommentCount>();
		    for (Video video : listdata) {
				String uuid = video.getUuid();
				
				CommentCount qv = cdao.totalVideoCommentCount(uuid);
		    	l.add(qv);
			}
			req.setAttribute("serchkeyword", keyword);
			req.setAttribute("queryVideoList", queryVideoList);
			System.out.println(l);
			req.setAttribute("commentlist", l);
             
			if(condition.equals("uploadUser")) {
				return "MyVideo.jsp";
			}
			
			if(user!=null&&user.getIdentity()==0) {
		
			return "videoManage.jsp";
			}
			else {
			
			return "videoSearch.jsp";
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "videoSearch.jsp";
	}
  @RequestMapping(value="/updatevideobyadmin")
  public void UpdateVideoCheckedByadminServlet(HttpServletRequest req, HttpServletResponse resp){
	  
	      try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Integer checked=0;
		String videouuid = req.getParameter("videouuid");
		String checkedStr = req.getParameter("checked");
		VideoInfoDao vid=new VideoInfoDao();
		if(StringUtils.hasLength(checkedStr)){
			 checked = Integer.valueOf(checkedStr);
			
		}
		if(vid.updateVideoChecked(videouuid, checked)){
			try {
				resp.getWriter().print(checked);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  
	  
  }

  @RequestMapping(value="/deletevideobyadmin")
  public void DeleteVideoByAdminServlet(HttpServletRequest req, HttpServletResponse resp){
		String videouuid = req.getParameter("videouuid");
	    VideoInfoDao vid=new VideoInfoDao();
	    Video video = vid.queryVideoAddress(videouuid);
	    String videoaddress=video.getAddress();
	    if(vid.queryVideoAddress(videouuid)!=null){
	        if(vid.deleteVideoInfo(videouuid)){
	    	System.out.println("delete+++++++++++++++++++++++++++");
	    	
	    	File videoaddresss = new File(videoaddress);
	    	System.out.println(videoaddresss);
//	    	  if(videoaddresss.delete()){
	    		  try {
	    			  System.out.println(videoaddresss.delete());
					resp.getWriter().print(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		  
//	    	  }
	    	
	    }
	    
	}
	  
	  
  }
  

  

  @RequestMapping(value="/UploadFileProgressServlet")
  @ResponseBody
  public String UploadFileProgressServlet(HttpSession session) throws Exception{
   FileUploadInfo status=(FileUploadInfo) session.getAttribute("status");

      if(status == null){  
     
          return "{'data':'NoData'}";
      }
    
      return status.toString();
  }
  
  @RequestMapping(value="/UploadFileServlet")
public void UploadFileServlet (@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req) {  
	 
	  String videotitle = req.getParameter("videotitle");
	    String videotype = req.getParameter("videotype");
	    String videodescript = req.getParameter("videodescript");
	            String uuid=UUID.randomUUID().toString();
	            String realName=uuid+file.getOriginalFilename();
	            long start = System.currentTimeMillis();  
	           
	            File filepath=new File("E:\\eclipsework\\movieProject\\WebRoot\\videosource\\"+realName);
	            
	 try {
		
	
				
		 file.transferTo(filepath);
					    
					    String ffpemg = req.getServletContext().getRealPath("/res/ffmpeg.exe");
					    String picturepath = "E:\\eclipsework\\movieProject\\WebRoot\\picture\\";
					    System.out.println(picturepath);
					    ffpemg.replaceAll("\\\\","/");
					    Video video = new Video();
			
					    	it.sauronsoftware.jave.Encoder encoder = new it.sauronsoftware.jave.Encoder();
					        it.sauronsoftware.jave.MultimediaInfo  info;
						
							info = encoder.getInfo(filepath);
							long duration = info.getDuration();
					    	String time =duration/(3600*1000) + ":" + duration%(3600*1000)/(60*1000) + ":" + duration%(3600*1000)%(60*1000)/1000;
					    	FFmpeg.Capture(ffpemg,filepath.getAbsolutePath(),"15","1",picturepath+uuid); 
					     
					    	video.setUuid(uuid);
					    	video.setName(videotitle);
					    	video.setAddress(filepath.getAbsolutePath());
					    	video.setDuration(time);
					        video.setType(videotype);
					        video.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					        User user=(User) req.getSession().getAttribute("user");
					        video.setUploadUser(user.getName() );
					        video.setIntroduction(videodescript);
					        video.setVideopicture("picture/"+uuid+".jpg");
					        if(user.getIdentity()==0) {
					        	video.setChecked(1);
					        }
						    VideoInfoDao vid=new VideoInfoDao();
						    boolean flag = vid.addVideoByAdmin(video);
		
				
	            System.out.println("文件用时:"+(System.currentTimeMillis()-start)+"毫秒");
	          
	    
	     
	 } catch (Exception e) {
			// TODO: handle exception
		 e.printStackTrace();
		}
	    }  
  
  
@RequestMapping(value="/uploadVideo")
public String uploadVideo() {
	return "videoUpload.jsp";
}
@RequestMapping(value="/danmuGet/{video}")
@ResponseBody
public ArrayList<VideoBarrage> danmuGet(@PathVariable("video")String uuid) {
   
	return projectService.getDanmu(uuid);
	
}

@RequestMapping(value="/danmuPost/{video}",produces={"application/json"})
@ResponseBody
public void danmuPost(@RequestBody VideoBarrage vb,
		HttpSession session,@PathVariable("video")String uuid) {
	



	User user=(User) session.getAttribute("user");
	
	System.out.println(vb.toString());
	projectService.insertDanmu(vb,uuid,user.getUuid());
	
	
}

@RequestMapping(value="/commentadd/{videouuid}")
@ResponseBody
public void commentadd(@RequestBody String comment ,HttpSession session,@PathVariable("videouuid") String uuid) throws Exception{
	User user=(User) session.getAttribute("user");
	String a = word.strword(comment);
	System.out.println(a);
	commentDao dao = new commentDao();
	VideoComment com = new VideoComment();
	com.setVideouuid(uuid);
	com.setComment(a);
	com.setUseruuid(user.getUuid());
	com.setTime(new Date(System.currentTimeMillis()).toLocaleString());
	com.setName(user.getName());
	dao.addCom(com);
	
}

@RequestMapping(value="/commentall/{videouuid}")
@ResponseBody
public List commentall(@PathVariable("videouuid") String uuid) throws Exception {
	commentDao dao = new commentDao();
	System.out.println(uuid);
	List<VideoComment> list = dao.VideoComments(uuid);
	System.out.println(list.toString());
    return list;
}
@RequestMapping(value="/commentown/{videouuid}")
@ResponseBody
public List commentown(@PathVariable("videouuid") String uuid,HttpSession session) throws Exception {
	commentDao dao = new commentDao();
	User user=(User) session.getAttribute("user");
	if(user==null) {
		user=new User();
	}
	List<VideoComment> list = dao.VideoComment(user.getUuid(),uuid);
	return list;
}
@RequestMapping(value="/saveProcess",produces={"application/json"})
@ResponseBody
public void saveProcess(@RequestBody VideoProcess vp) {
System.out.println(vp.toString());
	projectService.insertProcess(vp);
}

@RequestMapping(value="/getProcess",produces={"application/json"})
@ResponseBody
public float getProcess(@RequestBody VideoProcess vp) {
	vp=projectService.getProcess(vp);
	if(vp==null) {
		return 0;
	}
	return vp.getTime();
}
@RequestMapping(value="/manageMyInfo")
public String manageMyInfo() {
	return "Custom.jsp";
}
@RequestMapping(value="/adminManage")
public String adminManage() {
	return "videoManage.jsp";
}

}
