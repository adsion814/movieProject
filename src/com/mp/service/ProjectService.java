package com.mp.service;

import java.util.ArrayList;

import com.mp.bean.User;
import com.mp.bean.Video;
import com.mp.bean.VideoBarrage;
import com.mp.bean.VideoProcess;

public interface ProjectService {
     
	/**
	 * 通过名字查询视频信息
	 * @param name
	 * @return
	 */
	Video getVideoByName(String name);
	/**
	 * 判断用户是否存在
	 * @param email
	 * @return
	 */
	boolean userExit(String email);
	/**
	 * 设置vip
	 * @param user
	 */
	void setVip(User user);
	/**
	 * 获取用户
	 * @param uuid
	 * @return
	 */
	User getUserByUuid(String uuid);
	/**
	 * 加载弹幕
	 * @param uuid
	 * @return
	 */
	ArrayList<VideoBarrage> getDanmu(String uuid);
	
	/**
	 *插入弹幕
	 * @param vb
	 * @param videouuid
	 * @param useruuid
	 */
	void insertDanmu(VideoBarrage vb,String videouuid,String useruuid);

	/**
	 * 通过uuid查找视频
	 * @param uuid
	 * @return
	 */
	Video getVideoByUuid(String uuid);
	/**
	 * 返回所有视频
	 * @return
	 */
	ArrayList<Video> getAllVideo();
		/**
		 * 保存视频进度
		 * @param vp
		 */
	void insertProcess(VideoProcess vp);
	/**
	 * 获取视频进度
	 * @param vp
	 */
	VideoProcess getProcess(VideoProcess vp);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	void  updataUserInfo(User user);
	/**
	 * 获取用户上传的视频
	 * @param name
	 * @return
	 */
	ArrayList<Video> getUserVideo(String name);
	
	void addHot(Video video);
}
