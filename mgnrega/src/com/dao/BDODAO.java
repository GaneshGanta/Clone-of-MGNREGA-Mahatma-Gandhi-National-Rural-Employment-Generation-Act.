package com.dao;

import java.util.List;
import com.exceptions.*;
import com.beanClasses.*;

public interface BDODAO {
	
	
	public String createProject(String name,int dailyWages);
	
	public List<Project> viewAllProjects() throws ProjectException;
	
	public String createGPM(String name,String password);
	
	public List<GPM> viewAllGPM() throws GPMException;
	
	public List<GPM> unassignedGPM() throws GPMException;
	
	public String allocateProjectGpm(int gpmId,int projectId) throws ProjectException, GPMException;
	
	public List<Project> unassignedProject() throws ProjectException;
	
	public List<ProjectEmployee>  projectEmpDetails()throws ProjectException;

	
	
	 

}
