package com.usecases;

import java.util.List;

import com.beanClasses.GPM;
import com.beanClasses.Project;
import com.dao.BDODAO;
import com.dao.BDOImpl;
import com.exceptions.GPMException;
import com.exceptions.ProjectException;


public class UnassignedProjectToGPM {

	public static void unassignProject() {
		
		
		BDODAO bdo = new BDOImpl(); 
		
		try {
			System.out.println("Unassigned Projects");
			
			List<Project> list = bdo.unassignedProject();
			
			list.forEach(p->System.out.println(p));
			
			System.out.println("Unassigned GPMs");
			
			List<GPM> gpmlist = bdo.unassignedGPM();
			
			gpmlist.forEach(g->System.out.println(g));
		
		} catch (ProjectException e) {
			
			System.out.println(e.getMessage()); 
			
		} catch(GPMException e) {


			System.out.println(e.getMessage());
			
		}
	}

}
