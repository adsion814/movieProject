package com.mp.bean;

public class User {
    
	private String uuid;
	private String email;
	private String password;
	private Integer identity;
	private String name;
	private String picture;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String uuid, String email, String password, Integer identity, String name,String picture) {
		super();
		this.uuid = uuid;
		this.email = email;
		this.password = password;
		this.identity = identity;
		this.name = name;
		this.picture=picture;
	}
	public User() {
	
		// TODO 自动生成的构造函数存根
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", email=" + email + ", password=" + password + ", identity=" + identity
				+ ", name=" + name + ", picture=" + picture + "]";
	}
	
	

}
