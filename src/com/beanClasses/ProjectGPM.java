package com.beanClasses;

public class ProjectGPM {
	
	private int gpmId;
	private String gpmName;
	private int projectId;
	private String ProjectName;
	
	
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
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	@Override
	public String toString() {
		return "ProjectGPM [gpmId=" + gpmId + ", gpmName=" + gpmName + ", projectId=" + projectId + ", ProjectName="
				+ ProjectName + "]";
	}
	public ProjectGPM(String gpmName, int projectId, String projectName) {
		super();
		this.gpmName = gpmName;
		this.projectId = projectId;
		ProjectName = projectName;
	}
	public ProjectGPM() {
		super();
	}
	
	

}
