package com.usecases;

import com.dao.*;
import com.exceptions.*;
import java.util.*;

public class CreateProjectUseCase {
	
	
	public static void createProject()  {
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.out.println("Enter project name");
			String name = sc.nextLine();
			
			System.out.println("Enter daily wages for employees");
			int dwages = sc.nextInt();
		
			BDODAO bdo = new BDOImpl();
			
			String msg = bdo.createProject(name, dwages);
			
			System.out.println(msg);
		
		}
		catch(InputMismatchException ime) {
			
			System.out.println("Please enter proper values");
			
			
			
		}		
	}
}
