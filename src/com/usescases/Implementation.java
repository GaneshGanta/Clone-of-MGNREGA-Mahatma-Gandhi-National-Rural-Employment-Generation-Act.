package com.usescases;

import com.connects.*;
import com.beanClasses.*;
import com.dao.*;
import com.daoImplementation.*;
import com.exceptions.*;
import java.sql.*; 
import java.util.*;

public class Implementation {

	public static void main(String[] args)  {
		
		
		BDO obj = new BDOImplementation();
		
//		String mes = obj.createGPM("ganesh", "1234");
//		
//		System.out.println(mes);
		
		
		//view all gpm;
		
//		try {
//			List<gpm> list = obj.viewAllGPM();
//			
//			for(gpm el : list) {
//				
//				System.out.println(el);
//				
//			}
//			
//		} catch (GPMException e) {
//			
//			System.out.println(e.getMessage()); 
//		}
		
		
//		try {
//			
//			List<Project> list = obj.projectsUnassigned();
//			
//			for(Project el : list) {
//				
//				System.out.println(el); 
//			}
//			
//			
//		} catch (ProjectException e) {
//			
//			System.out.println(e.getMessage()); 
//		}
//		
		
		
	 try {
		 
		String msg = obj.allocateProjectToGPM(1, 1); 
		
		System.out.println(msg); 
		
	} catch (ProjectException e) {
		
		System.out.println(e.getMessage());
		
	} catch (GPMException e) {
		
		System.out.println(e.getMessage());

	}
		
		
		

	}

}
