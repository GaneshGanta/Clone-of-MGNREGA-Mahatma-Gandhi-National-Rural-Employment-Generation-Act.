package com.usecases;

import java.util.InputMismatchException;
import com.exceptions.*;
import java.util.Scanner;

import com.dao.GPMDAO;
import com.dao.GPMIMPL;


public class AssignProjectToEmployeeUseCase {

	public static void  assignEmp() {
		
		GPMDAO gpm = new GPMIMPL();
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter project Id");
			int pid = sc.nextInt();
			System.out.println("Enter employee Id");
			int eid = sc.nextInt();
			System.out.println("Enter number of days for employee will work");
			
			int days = sc.nextInt();
			
			try {
			
				String message = gpm.assignEmp(eid, pid, days);
				
				System.out.println(message);
			
			} catch (ProjectException | EmployeeException e) {
			
				System.out.println(e.getMessage());
			
			}
		
		} catch (InputMismatchException ime) {
			
			System.out.println("Please Enter valid inputs");
			
		}
				

	}

}
