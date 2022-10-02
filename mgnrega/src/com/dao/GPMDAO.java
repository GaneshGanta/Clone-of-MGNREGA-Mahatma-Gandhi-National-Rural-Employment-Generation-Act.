package com.dao;

import java.util.List;
import com.beanClasses.*;
import com.connection.*;
import com.dao.*;
import com.exceptions.*;
import java.sql.*;



public interface GPMDAO {
	
	
	public String loginAsGPM(int id,String password) throws GPMException;
	 
	public String createEmployee(String name);
	
	public List<Employee> viewEmpList(int gpmId) throws EmployeeException;
		
	public String assignEmp(int empId, int projectId,int days) throws ProjectException,EmployeeException;
	
	public List<ProjectEmployee>  projectEmpDetails(int gpmid)throws ProjectException,EmployeeException;
	

	

}
