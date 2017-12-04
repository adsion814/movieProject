package com.mp.bean;

import java.util.List;

public class CommentCount {
	private Long count;
	private String uuid;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public CommentCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentCount(Long count, String uuid) {
		super();
		this.count = count;
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "CommentCount [count=" + count + ", uuid=" + uuid + "]";
	}
	
	
	
	
	
	
	

}
