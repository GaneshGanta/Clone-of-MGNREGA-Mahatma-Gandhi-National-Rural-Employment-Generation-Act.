package com.beanClasses;

public class Employee {
	
	
	private int employeeId;
	private String employeeName;
	private int wage;
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
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", wage=" + wage + ", days="
				+ days + "]";
	}
	public Employee(String employeeName ) { 
		super();
		this.employeeName = employeeName;
		
	}
	
	
	
	

}
