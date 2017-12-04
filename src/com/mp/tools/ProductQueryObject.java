package com.mp.tools;

import java.util.ArrayList;




public class ProductQueryObject extends QueryObject {
	private String uuid;
	private String name;
	private String  uploaduser;
	private String introduction;
	private int checked;
	
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
	public String getUploaduser() {
		return uploaduser;
	}
	public void setUploaduser(String uploaduser) {
		this.uploaduser = uploaduser;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public ProductQueryObject(String uuid, String name, String uploaduser,
			String introduction) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.uploaduser = uploaduser;
		this.introduction = introduction;
	}
	public ProductQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void customquery() {
		if(StringUtils.hasLength(uuid)){
			super.add(" id = ? ",  uuid );
		}
            
		if (StringUtils.hasLength(name)) {
			
			super.add(" name LIKE ? ", "%" + name + "%");
		}
	
        if (checked!=-1) {
			
			super.add(" checked = ? ",checked );
		}
        if(StringUtils.hasLength(uploaduser)) {
        	super.add(" uploadUser = ? ", uploaduser);
        }
		
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	

	

}
