package com.mp.bean;

public class VideoProcess {
private float time;
private String useruuid;
private String videouuid;
public float getTime() {
	return time;
}
public void setTime(float time) {
	this.time = time;
}
public String getUseruuid() {
	return useruuid;
}
public void setUseruuid(String useruuid) {
	this.useruuid = useruuid;
}
public String getVideouuid() {
	return videouuid;
}
@Override
public String toString() {
	return "VideoProcess [time=" + time + ", useruuid=" + useruuid + ", videouuid=" + videouuid + "]";
}
public void setVideouuid(String videouuid) {
	this.videouuid = videouuid;
}

}
