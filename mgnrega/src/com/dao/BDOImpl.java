package com.dao;

import java.util.*;
import com.dao.*;
import com.exceptions.*;
import com.beanClasses.*;
import com.connection.*;
import java.sql.*;

public class BDOImpl implements BDODAO {
	
	

	
	
	@Override
	public String createProject(String name, int dailyWages) {
		
		
		String message = "Project could not be created";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into projects(projectName,dailywage) values(?,?)");
			ps.setString(1, name);
			ps.setInt(2, dailyWages);
			
			int res = ps.executeUpdate();
			if(res>0) {
				message = "Project created successfully";
			}
		}catch(SQLException se) {
			message = se.getMessage();
		}
		return message;
	}

	@Override
	public List<Project> viewAllProjects() throws ProjectException {
		
 		List<Project> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from projects"); 
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int projectId = rs.getInt("projectId");
				String projectName = rs.getString("projectName");
				int dailyWage = rs.getInt("dailywage");
				
				Project p = new Project(projectId, projectName,dailyWage);
				
				p.setProjectId(projectId);
				
				list.add(p);
			}
			
		}
		catch(SQLException sqe) {
			
			throw new ProjectException(sqe.getMessage());
		}
		
		if(list.size()==0) {
			throw new ProjectException("No project found");
		}
		return list;
	}

	@Override
	public String createGPM(String name,  String password) {
		
		
		String message = "Gram Panchayat member could not be created";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into gpm(gpmName,password) values(?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			
			int res = ps.executeUpdate();
			
			if(res>0) {
				message = "Gram panchayat member successfully added";
			}
			
		}
		catch(SQLException sqe) {
			
			message = sqe.getMessage();
		}
		
		return message;
	}

	@Override
	public List<GPM> viewAllGPM() throws GPMException {
		
		
		List<GPM> list = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
		
			PreparedStatement ps = conn.prepareStatement("select * from gpm");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpmId = rs.getInt("gpmId");
				String gpmName = rs.getString("gpmName");
				String password = rs.getString("password");
				
				
				GPM gpm = new GPM(gpmId, gpmName, password);
				
				
				list.add(gpm);
			}
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		if(list.size()==0) {
			throw new GPMException("No Gram panchayat member found");
		}
		return list ; 
	}
	

	@Override
	public String allocateProjectGpm(int gpmId, int projectId) throws ProjectException, GPMException {
		
		String message = "Project could not be allocated";
		
		try(Connection conn = DBUtil.provideConnection()){
		  
			
			PreparedStatement ps = conn.prepareStatement("select * from projects where pid=?");
		   
			ps.setInt(1, projectId);
		   
			ResultSet rs= ps.executeQuery();
		   
			if(rs.next()) {
			
				PreparedStatement ps2 = conn.prepareStatement("select * from gpm where gpmid=?");
			   
				ps2.setInt(1, gpmId);
			   
				ResultSet rs2 = ps2.executeQuery();
			   
				if(rs2.next()) {
				
					PreparedStatement ps3 = conn.prepareStatement("update gpm set pid=? where gpmid=?");
				   
					ps3.setInt(1, projectId);
				   
					ps3.setInt(2, gpmId);
				   
					int res = ps3.executeUpdate();
				   
					if(res>0) {
					   
						message = "Project allocated to gram panchayat member successfully";
				   
					}else {
					   
					   throw new ProjectException("Technical Error");
				   }
			   }else {
				   
				   throw new GPMException("Invalid GPM Id");
			   }
		   }else {
			 
			   throw new ProjectException("Invalid Project Id");
		   }
		}catch(SQLException sqe) {
			
			throw new ProjectException(sqe.getMessage());
		
		}
		
		return message;
	
	}

	@Override
	public List<Project> unassignedProject() throws ProjectException {
		
        List<Project> projectList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select p.projectId,p.projectName,p.dailywage from projects p left join gpm g on p.projectId=g.projectId where g.projectId is null;");
			
			ResultSet rs= ps.executeQuery();	
			while(rs.next()) {
				
				
				int projectId = rs.getInt("projectId");
				String projectName = rs.getString("projectName");
				int dailyWage = rs.getInt("dailywage"); 
				
				Project p = new Project(projectId,projectName,dailyWage); 
				projectList.add(p);
				
				
			}
		}catch(SQLException sqe) {
			
			throw new ProjectException(sqe.getMessage());
		}
		
		if(projectList.size()==0) {
			throw new ProjectException("No project is left unassigned");
		}
		return projectList;
	}
	
	@Override
	public List<GPM> unassignedGPM() throws GPMException {
		
		
		
		List<GPM> list  = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from gpm where pid is null");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpmId = rs.getInt("gpmid");
				String gpmName = rs.getString("gpmname");
				String password = rs.getString("password");
				
				GPM gpm = new GPM(gpmId, gpmName,password);
				
				list.add(gpm);
			
			}
		} catch (SQLException e) {
			
			throw new GPMException(e.getMessage());
			
		}
		 
		if(list.size()==0) {
			throw new GPMException("No Gram panchayat member is left unassigned");
		}
		return list;
	}



	
	
	@Override
	public List<ProjectEmployee> projectEmpDetails() throws ProjectException {
		
		
		List<ProjectEmployee> list = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select e.employeeId,e.employeeid,p.projectid,p.projectName,sum( ep.days)*p.dailywage, sum(ep.days) from employeeproject ep,employee e ,projects p where ep.eid= e.employeeId AND ep.pid = p.projectId group by p.projectid;");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) { 
			
				int projectId = rs.getInt("projectid");
				String projectName = rs.getString("projectName");
				int empId = rs.getInt("employeeId");
				String empName = rs.getString("employeeName");
				int days = rs.getInt("days");
				int wage = rs.getInt("twage");
				
				ProjectEmployee ped = new ProjectEmployee(projectId,projectName,empId,empName,wage,days);
				
				list.add(ped);
			}
		}catch(SQLException e) {
			
			throw new ProjectException("Technical Error");
		}
		if(list.size()==0) {
			
			throw new ProjectException("No employee is working on projects");
		} 
		return list;
	}
	
	
	

}
