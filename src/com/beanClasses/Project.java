package com.beanClasses;

public class Project {
	
	
	private int projectId;
	private String  projectName;
	private int budjget;
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
	public Project(String projectName, int budjget) {
		super();
		this.projectName = projectName;
		this.budjget = budjget;
	}
	public Project() {
		super();
	}
	
	
	
	
	
	
	
	
	
	

}
