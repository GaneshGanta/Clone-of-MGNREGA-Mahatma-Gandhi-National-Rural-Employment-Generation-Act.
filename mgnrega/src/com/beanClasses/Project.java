package com.beanClasses;

public class Project {
	
	

	private int projectId;
	private String  projectName;
	private int wage;
	
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
	
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", wage=" + wage + "]";
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;  
	}
	public Project() {
		super();
	}
	public Project(int projectId, String projectName, int dailywage) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.wage = dailywage;
	}
	
	
	
	

}
