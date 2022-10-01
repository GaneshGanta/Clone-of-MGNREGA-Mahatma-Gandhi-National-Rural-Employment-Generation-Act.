package com.beanClasses;

public class Employee {
	
	
	private int employeeId;
	private String employeeName;
	private int days;
	private int proId;
	
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
	
	public Employee(int employeeId, String employeeName, int days, int proId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.days = days;
		this.proId = proId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", days=" + days + ", proId="
				+ proId + "]";
	}
	public Employee(String employeeName ) { 
		super();
		this.employeeName = employeeName;
		
	}
	
	
	
	

}
