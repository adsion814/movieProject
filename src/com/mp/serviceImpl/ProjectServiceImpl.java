package com.mp.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.bean.User;
import com.mp.bean.Video;
import com.mp.bean.VideoBarrage;
import com.mp.bean.VideoProcess;
import com.mp.service.ProjectService;
import com.mp.tools.JDBCUtils;
@Service
public class ProjectServiceImpl implements ProjectService {

	JDBCUtils jdbc=JDBCUtils.getJDBC();
	ArrayList<Object> params=new ArrayList<Object>();

	public Video getVideoByName(String name) {
		// TODO 自动生成的方法存根
	params.clear();
		params.add(name+"%");
		params.add(1);
		try {
			Video video=jdbc.findSimpleRefResult("select * from videoinfo where name like ? and checked = ?", params, Video.class);
	
			return video;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}


	public boolean userExit(String email) {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(email);
		try {
			User user=jdbc.findSimpleRefResult("select * from userinfo where emial = ?", params, User.class);
		  if(user!=null) return true;
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public void setVip(User user) {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(user.getUuid());
		try {
			jdbc.updateByPreparedStatement("update userinfo set identity = 1 where uuid=?", params);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	public User getUserByUuid(String uuid) {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(uuid);
		User user = null;
		try {
			 user = jdbc.findSimpleRefResult("select * from userInfo where uuid=?", params, User.class);
			 String str=user.getPicture();
			 str=str.substring(str.lastIndexOf("\\")+1,str.length());
			  str="img/"+str;
			  user.setPicture(str);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
		return user;
	}


	public ArrayList<VideoBarrage> getDanmu(String uuid) {
		// TODO 自动生成的方法存根
		List<VideoBarrage> list = null;
		try {
			params.clear();
			params.add(uuid);
			list=jdbc.findMoreRefResult("select text,color, size,position,time from videobarrage where videouuid=?", params, VideoBarrage.class);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return (ArrayList<VideoBarrage>) list;
	}

   
	public void insertDanmu(VideoBarrage vb,String videouuid,String useruuid) {
		
		// TODO 自动生成的方法存根
		params.clear();
		params.add(videouuid);
		params.add(vb.getText());
		params.add(vb.getColor());
		params.add(vb.getSize());
		params.add(vb.getPosition());
		params.add(vb.getTime());
		params.add(useruuid);
		
		try {
			jdbc.updateByPreparedStatement("insert into videobarrage values(?,?,?,?,?,?,?)", params);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
	}

	public Video getVideoByUuid(String uuid) {
		params.clear();
		params.add(uuid);
		try {
			Video video=jdbc.findSimpleRefResult("select * from videoinfo where uuid = ?", params, Video.class);
	
			return video;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Video> getAllVideo() {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(1);
		try {
			return (ArrayList<Video>) jdbc.findMoreRefResult("select * from videoinfo where checked = ?", params, Video.class);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}


	public void insertProcess(VideoProcess vp) {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(vp.getUseruuid());
		params.add(vp.getVideouuid());
		try {
			VideoProcess temp=jdbc.findSimpleRefResult("select * from videoprocess where useruuid=? and videouuid=?", params, VideoProcess.class);
			if(temp==null) {
				params.clear();
				params.add(vp.getVideouuid());
				params.add(vp.getUseruuid());
				params.add(vp.getTime());
				jdbc.updateByPreparedStatement("insert into videoprocess values(?,?,?)", params);
			}
			else {
				params.clear();
				params.add(vp.getTime());
				params.add(vp.getVideouuid());
				params.add(vp.getUseruuid());
		
				jdbc.updateByPreparedStatement("update videoprocess set time=? where videouuid=? and useruuid=?", params);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}


	public VideoProcess getProcess(VideoProcess vp) {
		// TODO 自动生成的方法存根
		params.clear();
		params.add(vp.getUseruuid());
		params.add(vp.getVideouuid());
		 try {
			vp=jdbc.findSimpleRefResult("select * from videoprocess where useruuid=? and videouuid=?" , params, VideoProcess.class);
			return vp;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 return null;
		
	}
	
public void updataUserInfo(User user) {
	params.clear();
	params.add(user.getName());
	params.add(user.getPassword());
	params.add(user.getPicture());
	params.add(user.getUuid());
	
	
	try {
		jdbc.updateByPreparedStatement("update userinfo set name=?,password=?,picture=? where uuid=?", params);
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	// TODO 自动生成的方法存根
	
}
public ArrayList<Video> getUserVideo(String name){
	params.clear();
	params.add(name);
	
	try {
		return (ArrayList<Video>) jdbc.findMoreRefResult("select * from videoinfo where uploadUser=?", params, Video.class);
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return null;
}

public void addHot(Video video) {
	params.clear();
	params.add(video.getHot());
	params.add(video.getUuid());
	try {
		jdbc.updateByPreparedStatement("update videoinfo set hot=? where videouuid=?", params);
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	// TODO 自动生成的方法存根
	
	
}
}
