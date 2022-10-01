package com.beanClasses;

public class gpm {
	
	
	private int gpmId;
	private String gpmName;
	private String password;
	private int projectId;
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public gpm(String gpmName, String password) {
		super();
		this.gpmName = gpmName;
		
		this.password = password;
	}
	public gpm() {
		super();
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "gpm [gpmId=" + gpmId + ", gpmName=" + gpmName + ", password=" + password + ", projectId=" + projectId
				+ "]";
	}
	public gpm(int gpmId, String gpmName, String password) {
		super();
		this.gpmId = gpmId;
		this.gpmName = gpmName;
		this.password = password;
		
	}
	
	
	
	
	
	
	
	
	

}
