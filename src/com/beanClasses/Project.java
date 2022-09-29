package com.beanClasses;

public class Project {
	
	
	
	private int projectId;
	private String  projectName;
	private int budjget;
	private int dailyWage;
	
	
	public Project(String projectName, int budjget, int dailyWage) {
		super();
		this.projectName = projectName;
		this.budjget = budjget;
		this.dailyWage = dailyWage;
	}
	public int getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(int dailyWage) {
		this.dailyWage = dailyWage;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getBudjget() {
		return budjget;
	}
	public void setBudjget(int budjget) {
		this.budjget = budjget;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", budjget=" + budjget + "]";
	}
	
	public Project() {
		super();
	}
	
	
	
	
	
	
	
	
	
	

}
