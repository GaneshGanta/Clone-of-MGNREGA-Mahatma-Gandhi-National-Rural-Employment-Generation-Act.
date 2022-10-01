package com.daoImplementation;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.beanClasses.*;
import com.connects.Linking;
import com.dao.*;
import com.exceptions.*;




public class BDOImplementation implements  BDO{

	@Override
	public String createProject(String projectName, int projectBudget, int dailyWage) {
		
		String message = "Project not created...";
		
		
		try( Connection link = Linking.establishConnection() ) {
			
			
			PreparedStatement ps= link.prepareStatement 
					("insert into projects(projectName,projectBudget,dailyWage) values(?,?,?)");
			
			
			
			ps.setString(1, projectName); 
			ps.setInt(2, projectBudget);
			ps.setInt(3, dailyWage);
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Student Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message; 
		
		
		
	}

	@Override
	public List<Project> viewAllProjects() throws ProjectException {
		
		List<Project> list = new ArrayList<>();
		
		
		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement("select * from projects"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int pid= rs.getInt("projectId");
				String name= rs.getString("projectName");
				int budget= rs.getInt("projectBudget");
				int wage = rs.getInt("dailyWage"); 
				
				
				Project obj = new Project(pid, name,budget, wage);
				
				list.add(obj);
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new  ProjectException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new ProjectException("No projects found..."); 
		
		
		
		
		return list; 
	}

	@Override
	public String createGPM(String gpmName, String password) {
		
		String message = "not created ...";
		
		try( Connection link = Linking.establishConnection() ) {
			
			
			PreparedStatement ps= link.prepareStatement 
					("insert into gpm(gpmName,password) values(?,?)");
			
			
			
			ps.setString(1, gpmName); 
			ps.setString(2, password); 
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "gram panchayat member created Sucessfully !";
			
			
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		return message; 
		
	}

	@Override
	public List<gpm> viewAllGPM() throws GPMException {
		
		List<gpm> list = new ArrayList<>();
		
		

		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement("select * from gpm"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int pid = rs.getInt("gpmId");
				String name = rs.getString("gpmName");
				String password = rs.getString("password"); 
				
				
				gpm obj = new gpm(pid, name,password);
				list.add(obj);
				
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new GPMException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new GPMException("No projects found...");
		
		
		
		return list; 
		
		
	}
//	------------------------------------------------------------------------------------------------------------------------

	@Override
	public String allocateProjectToGPM(int GPMID, int projectId) throws ProjectException, GPMException {
		
		
		
		String message ="Not allocated...";
		
		
		try(Connection conn= Linking.establishConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from projects where projectId =?");
			
		 	
		 	ps.setInt(1, projectId);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from gpm where gpmId=?");
		 		
		 		ps2.setInt(1, GPMID);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			
//
//		 			PreparedStatement ps3= conn.prepareStatement("insert into course_student values(?,?)");
//		 			
//		 			
//		 			ps3.setInt(1, cid);
//		 			ps3.setInt(2, roll);
//		 			
//		 			int x= ps3.executeUpdate();
//		 			
//		 			if(x > 0)
		 				message = "project allocated to Gram Panchayat Member(GPM)  Sucessfully... ";
//		 			else
//		 				throw new StudentException("Techical error..");
//		 			
		 			
		 			
		 		}
		 		else
		 			throw new GPMException ("Invalid GRAM PANCHAYAT MEMBER...");
		 		
		 		
		 		
		 		
		 	}else
		 		throw new ProjectException("Invalid project...");
		 	
		   
			
			
			
			
			
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		
		
		return message;
		
		
	}
	
	
	
	
	
	
//	--------------------------------------------------------------------------------

	@Override
	public List<Project> projectsUnassigned() throws ProjectException {
		
		List<Project> list = new ArrayList<>();
		
		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement
					("select p.projectId,p.projectName,p.projectbudget,p.dailywage from projects p, gpm g where g.proId != p.projectId;"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int pid= rs.getInt("projectId");
				String name= rs.getString("projectName");
				int budget= rs.getInt("projectBudget");
				int wage = rs.getInt("dailyWage"); 
				
				
				Project obj = new Project(pid, name,budget, wage);
				
				list.add(obj);
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new  ProjectException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new ProjectException("All projects are assigned ..."); 
		
		
		
		
		return list; 

		
	}

	@Override
	public List<projectEmployee> employeeWorkingProject() throws ProjectException {
		
		
		
		List<projectEmployee> list = new ArrayList<>();
		
		
		try( Connection conn= Linking.establishConnection() ) {
			
			PreparedStatement ps = conn.prepareStatement("select * from projects"); 
			
			
			
			ResultSet rs= ps.executeQuery(); 
			
			while(rs.next()) {
				
				
				int pid= rs.getInt("projectId");
				String name= rs.getString("projectName");
				int budget= rs.getInt("projectBudget");
				int wage = rs.getInt("dailyWage"); 
				
				
//				projectEmployee obj = new projectEmployee(pid, name,budget, wage);
//				
//				list.add(obj);
				
		
//7. See List of Employee working on that Project and their wages.
				 
			}
			
			
		} catch (SQLException e) {
			
			throw new  ProjectException(e.getMessage()); 
		}
		
		
		if(list.size() == 0)
			
			throw new ProjectException("No projects found..."); 
		
		
		return list; 
		
		
	}
	
	

}
