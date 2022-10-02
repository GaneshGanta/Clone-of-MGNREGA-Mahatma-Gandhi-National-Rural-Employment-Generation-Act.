package com.usecases;

import java.util.List;

import com.beanClasses.Project;
import com.dao.BDODAO;
import com.dao.BDOImpl;
import com.exceptions.ProjectException;

import java.util.*; 



public class ViewAllProjectUseCase {

	public static void viewProjects() {
		
		BDODAO bdo = new BDOImpl();
		
		try {
			
			List<Project> list = bdo.viewAllProjects();
			
			for(Project e : list) {
				
				System.out.println(e);
				
			}
			
		} catch (ProjectException e) {
			
			
			System.out.println(e.getMessage());
			
		}
		
		

	}

}
