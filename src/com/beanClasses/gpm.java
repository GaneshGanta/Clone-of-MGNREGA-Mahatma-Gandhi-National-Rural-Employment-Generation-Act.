package com.beanClasses;

public class gpm {
	
	
	private int gpmId;
	private String gpmName;
	private String phone;
	private String password;
	public int getGpmId() {
		return gpmId;
	}
	public void setGpmId(int gpmId) {
		this.gpmId = gpmId;
	}
	public String getGpmName() {
		return gpmName;
	}
	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public gpm(String gpmName, String phone, String password) {
		super();
		this.gpmName = gpmName;
		this.phone = phone;
		this.password = password;
	}
	public gpm() {
		super();
	}
	
	
	
	
	
	
	

}
