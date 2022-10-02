package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.beanClasses.Employee;
import com.dao.GPMDAO;
import com.dao.GPMIMPL;
import com.exceptions.EmployeeException;


public class ViewEmpListUseCase {

	public static void viewEmp() {
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Enter your gpmid:");
		
		int gpmid = in.nextInt();
		
		GPMDAO gpm = new GPMIMPL();
		
		
		try {
			
			List<Employee> list = gpm.viewEmpList(gpmid); 
			
			for(Employee e : list) {
				
				System.out.println(e); 
				
			}
			
			
		} catch (EmployeeException e) {
			
			
			System.out.println(e.getMessage());
		
		}
		

	}

}
