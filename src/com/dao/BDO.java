package com.dao;

import java.util.List;

import com.beanClasses.*;

import com.exceptions.*;

public interface BDO {
	
	
	public String createProject(String projectName, int projectBudget, int dailyWage);
	
	public List<Project> viewAllProjects() throws ProjectException;
	
	public  String createGPM(String gpmName,String password); 
	
	public List<gpm> viewAllGPM () throws GPMException;
	
	public String  allocateProjectToGPM(int GPMID, int projectId) throws ProjectException, GPMException;  
	
	public List<Project> projectsUnassigned () throws ProjectException;
	
	public List<projectEmployee>  employeeWorkingProject () throws ProjectException;
	
	
	
}
