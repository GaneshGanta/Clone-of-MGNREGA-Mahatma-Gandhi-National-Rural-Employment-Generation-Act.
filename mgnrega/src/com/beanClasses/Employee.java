package com.beanClasses;

public class Employee {
	
	

	private int employeeId;
	private String employeeName;
	private int gmdId;
	
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
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", gmdId=" + gmdId + "]";
	}
	public Employee(int employeeId, String employeeName, int days) { 
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gmdId = days;
	}
	public int getDays() {
		return gmdId;
	}
	public void setDays(int days) {
		this.gmdId = days; 
	}
	
	public Employee(String employeeName ) { 
		super();
		this.employeeName = employeeName;
		
	}
	
	
	
	

}
