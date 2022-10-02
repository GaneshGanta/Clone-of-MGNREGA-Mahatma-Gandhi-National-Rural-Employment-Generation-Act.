package com.usecases;


import java.util.Scanner;
import com.dao.*;

public class CreateEmployeeUseCase {
	
	
	public static void createEmp() {
	
		Scanner sc = new Scanner(System.in);
		
		GPMDAO gpm = new GPMIMPL();
		
		System.out.println("Enter Name");
		String name = sc.nextLine();
		
		String message = gpm.createEmployee(name);
		System.out.println(message);
		
	}
}
