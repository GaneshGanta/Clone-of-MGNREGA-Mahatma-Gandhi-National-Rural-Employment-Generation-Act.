package com.usecases;

import com.beanClasses.ProjectEmployee;
import com.dao.*;
import com.exceptions.*;
import java.util.*;
import com.usecases.*;

public class ViewAllEmpPro {
	
	
	public static void  viewEmpPro()  {
		
		
		BDODAO obj = new BDOImpl();
		
		try {
		
			List<ProjectEmployee> list =  obj.projectEmpDetails();
			
			for(ProjectEmployee e : list) {
				
				System.out.println(e);
			}
					
					
		
		}catch (ProjectException e) {
			
			System.out.println(e.getMessage()); 
			
		}
		
		
		
	}

}
