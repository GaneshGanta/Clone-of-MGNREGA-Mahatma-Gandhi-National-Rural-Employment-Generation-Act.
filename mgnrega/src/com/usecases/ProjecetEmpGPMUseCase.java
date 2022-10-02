package com.usecases;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import com.beanClasses.ProjectEmployee;
import com.dao.GPMDAO;
import com.dao.GPMIMPL;
import com.exceptions.*;


public class ProjecetEmpGPMUseCase {

	public static void projectEmp() {
       
		Scanner sc= new Scanner(System.in);
		
		try {
			
			System.out.println("Enter gram panchyat member Id to get Employee List with project");
			
			int gpmid = sc.nextInt();
			
			GPMDAO gpm = new GPMIMPL();
			
			
			try {
				List<ProjectEmployee> ped = gpm.projectEmpDetails(gpmid);   
				
				for(ProjectEmployee e : ped) {
					
					System.out.println(e); 
					
				}
				
				
			} catch (ProjectException | EmployeeException e) {
				
				System.out.println(e.getMessage());
			}
			
		} catch (InputMismatchException e) {
			
			System.out.println("Please enter only in number"); 
			
		}

	}

}
