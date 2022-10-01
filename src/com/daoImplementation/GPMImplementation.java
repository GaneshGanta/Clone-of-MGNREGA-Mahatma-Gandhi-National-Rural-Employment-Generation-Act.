package com.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.beanClasses.*;
import com.connects.Linking;
import com.dao.*;
import com.exceptions.*;

public class GPMImplementation implements   GPM {
	
	public static void main(String[] args) {
		
		
		GPM obj = new GPMImplementation();
		
		
		try {
			
			List<Employee> list = obj.employeesWithoutJob();
			
			for(Employee e : list) {
				
				System.out.println(e); 
				
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		
	}

	@Override
	public gpm authorization(int id, String password) throws GPMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creatingEmployee(String employeeName) {
		
		
		String message = "employee not created...";
		
		
		try( Connection link = Linking.establishConnection() ) {
			
			
			PreparedStatement ps= link.prepareStatement 
					("insert into employee(employeeName) values(?)");
			
			
			
			ps.setString(1, employeeName);  
			
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Student Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message;
		
		
		
	}

	@Override
	public List<Employee> viewAllEmployees() throws EmployeeException {
		
		
		List<Employee> list = new ArrayList<>(); 
		
		
		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int empId = rs.getInt("employeeId");
				String empName = rs.getString("employeeName");
				int days = rs.getInt("workdays");
				int proId = rs.getInt("projectId");  
				
				
				Employee obj = new Employee(empId, empName, days, proId);
				
				list.add(obj);
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new  EmployeeException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new EmployeeException("No projects found..."); 
		
		
		
		
		return list;
		
		
		
		
		
	}

	@Override
	public List<Employee> employeesWithoutJob() throws EmployeeException {
		
		
		
		List<Employee> list = new ArrayList<>(); 
		
		
		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee  where projectId is null"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int empId = rs.getInt("employeeId");
				String empName = rs.getString("employeeName");
				int days = rs.getInt("workdays");
				int proId = rs.getInt("projectId");  
				
				
				Employee obj = new Employee(empId, empName, days, proId);
				
				list.add(obj);
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new  EmployeeException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new EmployeeException("No projects found..."); 
		
		
		
		
		return list;
		
		
		
	}

	@Override
	public String AssigningProjectToEmployee(int employeeId, int ProjectId) throws ProjectException, EmployeeException {
		
		
		
		return null;
		
		
	}

	@Override
	public List<projectEmployee> employeeWorkingProject() throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
