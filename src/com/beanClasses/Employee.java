package com.beanClasses;

public class Employee {
	
	
	private int employeeId;
	private String employeeName;
	private int days;
	
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
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", days="
				+ days + "]";
	}
	public Employee(String employeeName ) { 
		super();
		this.employeeName = employeeName;
		
	}
	
	
	
	

}
