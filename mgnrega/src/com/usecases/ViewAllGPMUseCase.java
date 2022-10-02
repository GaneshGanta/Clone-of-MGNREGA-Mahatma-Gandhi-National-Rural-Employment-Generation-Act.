package com.usecases;

import java.util.List;

import com.beanClasses.GPM;
import com.dao.BDODAO;
import com.dao.BDOImpl;
import com.exceptions.GPMException;


public class ViewAllGPMUseCase {
	
	
	public static void viewGPM() {
	
		BDODAO bdo = new BDOImpl();
		
		try {
			
			List<GPM> list  = bdo.viewAllGPM();
			
			for(GPM e :list) {
				
				System.out.println(e);
				
			}
			
		} catch (GPMException e) { 
			
			
			System.out.println(e.getMessage());
		
		}
	}
}
 