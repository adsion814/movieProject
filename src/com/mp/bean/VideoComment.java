package com.mp.bean;

public class VideoComment {
	private  String videouuid;
	private  String comment;
	private  String useruuid;
	private  String time;
	private String name;
	public VideoComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoComment(String videouuid, String comment, String useruuid,
			String time) {
		super();
		this.videouuid = videouuid;
		this.comment = comment;
		this.useruuid = useruuid;
		this.time = time;
	}
	public String getVideouuid() {
		return videouuid;
	}
	public void setVideouuid(String videouuid) {
		this.videouuid = videouuid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUseruuid() {
		return useruuid;
	}
	public void setUseruuid(String useruuid) {
		this.useruuid = useruuid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "VideoComment [videouuid=" + videouuid + ", comment=" + comment
				+ ", useruuid=" + useruuid + ", time=" + time + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
