package com.dao;

import java.util.List;

import com.beanClasses.*;
import com.exceptions.*;

public interface GPM {
	
	
	public gpm authorization(int id,String password) throws GPMException;
	
	public String creatingEmployee(String employeeName); 
	
	public List<Employee> viewAllEmployees() throws EmployeeException;
	
	public List<Employee> employeesWithoutJob() throws EmployeeException;
	
	public String AssigningProjectToEmployee(int employeeId,int ProjectId) throws ProjectException,EmployeeException;
	
	public List<projectEmployee> employeeWorkingProject() throws EmployeeException,ProjectException;   
	

}
