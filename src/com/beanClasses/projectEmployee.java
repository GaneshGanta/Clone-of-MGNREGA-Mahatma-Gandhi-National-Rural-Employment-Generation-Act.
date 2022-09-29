package com.beanClasses;

public class projectEmployee {
	
	
	private int projectId;
	private String projectName;
	private int employeeId;
	private String employeeName;
	private int wage;
	private int days;
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "projectEmployee [projectId=" + projectId + ", projectName=" + projectName + ", employeeId=" + employeeId
				+ ", employeeName=" + employeeName + ", wage=" + wage + ", days=" + days + "]";
	}
	public projectEmployee(int projectId, String projectName, int employeeId, String employeeName, int wage, int days) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.wage = wage;
		this.days = days;
	}
	public projectEmployee() {
		super();
	}
	
	
	
	
	

}
