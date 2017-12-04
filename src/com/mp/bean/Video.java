package com.mp.bean;


public class Video {
   private String uuid;
   private String name;
   private String address;
   private String duration;
   private long hot=0;
   private String uploadTime;
   private String type;
   private String uploadUser;
   private String introduction;

   private int checked=0;
   private String videopicture;
   private int askVip=0;
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public long getHot() {
	return hot;
}
public void setHot(long hot) {
	this.hot = hot;
}
public String getUploadTime() {
	return uploadTime;
}
public void setUploadTime(String uploadTime) {
	this.uploadTime = uploadTime;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getUploadUser() {
	return uploadUser;
}
public void setUploadUser(String uploadUser) {
	this.uploadUser = uploadUser;
}
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}

public int getChecked() {
	return checked;

}
public void setChecked(int checked) {
	this.checked = checked;
}




public String getVideopicture() {
	return videopicture;
}
public void setVideopicture(String videopicture) {
	this.videopicture = videopicture;
}

public int getAskVip() {
	return askVip;
}



public void setAskVip(int askVip) {
	this.askVip = askVip;
}
public Video() {
	super();
	// TODO Auto-generated constructor stub
}
public Video(String uuid, String name, String address, String duration,
		long hot, String uploadTime, String type, String uploadUser,
		String introduction, int checked, String videopicture, int askVip) {
	super();
	this.uuid = uuid;
	this.name = name;
	this.address = address;
	this.duration = duration;
	this.hot = hot;
	this.uploadTime = uploadTime;
	this.type = type;
	this.uploadUser = uploadUser;
	this.introduction = introduction;
	this.checked = checked;
	this.videopicture = videopicture;
	this.askVip = askVip;
}
@Override
public String toString() {
	return "Video [uuid=" + uuid + ", name=" + name + ", address=" + address
			+ ", duration=" + duration + ", hot=" + hot + ", uploadTime="
			+ uploadTime + ", type=" + type + ", uploadUser=" + uploadUser
			+ ", introduction=" + introduction + ", checked=" + checked
			+ ", videopicture=" + videopicture + ", askVip=" + askVip + "]";
}



}
