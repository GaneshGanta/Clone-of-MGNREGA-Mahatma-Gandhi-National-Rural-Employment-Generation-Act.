package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connection.*;
import com.beanClasses.*;
import com.dao.*;
import com.exceptions.*;

public class GPMIMPL implements GPMDAO{
	
	
	
	@Override
	public String loginAsGPM(int id, String password) throws GPMException {
		
		 String msg = "login cancel";
		
		GPM gpm5 = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select * from gpm where gpmid = ? and password = ?");
			
			ps.setInt(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				msg = "welcome";
				
				
					
			
			}else {
				
				throw new GPMException("Invalid Id or Password");
				
			}
		
		}catch(SQLException sqe) {
		
			throw new GPMException(sqe.getMessage());
		}
		
		return msg;
	
	}

	@Override
	public String createEmployee(String name) {
		
		String message = "Employee could not be created";
		
		try(Connection conn = DBUtil.provideConnection()){
		
			PreparedStatement ps = conn.prepareStatement("insert into employee(employeeName,gpmId) values(?,0)");
			
			ps.setString(1, name);
			
			int x = ps.executeUpdate(); 
			
			if(x>0) {
				message = "Employee created successfully!";
			
			}
			
		}catch(SQLException sqe) {
			
			message = sqe.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Employee> viewEmpList(int gpmId)  throws EmployeeException { 
		
		
		List<Employee> list = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
		
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where gpmId = ?");
			
			ps.setInt(1, gpmId);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
			
				int empId = rs.getInt("employeeId");
				String eName = rs.getString("employeeName"); 
				int gmpId = rs.getInt("gpmId");
				
				Employee e = new Employee(empId, eName,gpmId);
				
				list.add(e);
			}
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
			if(list.size()==0) {
				throw new EmployeeException("No employee found");
			}
			return list;
	}



	@Override
	public String assignEmp(int empId, int projectId,int days) throws ProjectException, EmployeeException {
	
		String message = "Project assigned to employee successfully";
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("select * from projects where projectid=?");
			
			ps.setInt(1, projectId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			
				PreparedStatement ps2 = conn.prepareStatement("select * from employee where employeeid=?");
				
				ps2.setInt(1, empId);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
				
					PreparedStatement ps3 = conn.prepareStatement("update employeeproject set pid=?,days=? where eid=?");
					
					ps3.setInt(1, projectId);
					ps3.setInt(2, days);
					ps3.setInt(3, empId);
					
					int res = ps3.executeUpdate();
					
					if(res>0) {
						message = "Project assigned to employee successfully";
						
					}else {
						
						throw new ProjectException("Technical Error");
						
					}
				}else {
					throw new EmployeeException("Invalid Employee Id");
				}
			}else {
				throw new ProjectException("Invalid project Id");
			}
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<ProjectEmployee> projectEmpDetails(int gpmId) throws ProjectException, EmployeeException {
		
		
		List<ProjectEmployee> list = new ArrayList<>(); 
		
		
		try(Connection conn = DBUtil.provideConnection()){
		
			
			PreparedStatement ps = conn.prepareStatement
					(" select e.employeeName,p.projectId , sum(days)*p.dailywage wage from employeeproject ep , employee e, projects p where ep.eid = e.employeeid AND ep.pid = p.projectId AND e.gpmid = ? group by projectId;");
			
				
			ps.setInt(1, gpmId); 
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
			
				
				int projectId = rs.getInt("projectId");
				String projectName = rs.getString("projectName");
				int empId = rs.getInt("employeeId");
				String empName = rs.getString("employeeName");
				int days = rs.getInt("days");
				int wage = rs.getInt("wage");
				
				
				ProjectEmployee ped = new ProjectEmployee(projectId,projectName,empId,empName,wage,days);
				
				list.add(ped);
			}
		}
		catch(SQLException e) {
			
			throw new ProjectException("Technical Error");
		}
		
		if(list.size()==0) {
			
			throw new ProjectException("No employee is working on projects");
		
		}
		
		return list;
	
	}
	
	
	
	
	

	
	

}
