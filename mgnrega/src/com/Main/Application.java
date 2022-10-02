package com.Main;

import java.util.*;
import com.dao.*;
import com.usecases.AllocateProjectToGPMUseCase;
import com.usecases.AssignProjectToEmployeeUseCase;
import com.usecases.CreateEmployeeUseCase;
import com.usecases.CreateGPMUseCase;
import com.usecases.CreateProjectUseCase;
import com.usecases.LoginAsGPMUseCase;
import com.usecases.ViewAllEmpPro;
import com.usecases.ViewAllGPMUseCase;
import com.usecases.ViewAllProjectUseCase;
import com.usecases.ViewEmpListUseCase;


public class Application {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		while(true) {
		
		System.out.println("1.Login as BDO ...");
		System.out.println("2.login as GPM ....");
		
		
		int choice = in.nextInt();
		
		if(choice ==1) {
			
			
			 
			System.out.println("id = 1234, password = BDO" ); 
			
			System.out.println("Enter id :");
			int id = in.nextInt();
			System.out.println("Enter password :");
			String pass = in.next();
			
			if(id==1234 && pass.equals("BDO")) {
				
				while(true) {
					
					System.out.println("1. Create a project.\r\n"
							+ "2. View List Of Project.\r\n"
							+ "3. Create new Gram Panchayat Member(GPM).\r\n"
							+ "4. View all the GPM.\r\n"
							+ "5. Allocate  Project to GPM\r\n"
							+ "6. See List of Employee working on that Project and their wages.\r\n"
							+ "7.Break.");
					
					int select = in.nextInt();
					
					
					
					if(select == 1) {
						
						CreateProjectUseCase obj = new CreateProjectUseCase(); 
						
						obj.createProject();
						System.out.println("===============================================================================");

						
						
					}if(select == 2) {
						
						ViewAllProjectUseCase obj = new ViewAllProjectUseCase();
						
						obj.viewProjects();
						System.out.println("===============================================================================");

						
						
					}if( select == 3 ) {
						
						CreateGPMUseCase obj = new CreateGPMUseCase();
						
						obj.createGPM();
						System.out.println("===============================================================================");

						
						
					}if(select == 4) {
						
						ViewAllGPMUseCase obj = new ViewAllGPMUseCase();

						System.out.println("===============================================================================");
 
						
						
					}if(select == 5) {
						
						AllocateProjectToGPMUseCase obj = new AllocateProjectToGPMUseCase();
						obj.allocateGPM();
						 
						System.out.println("===============================================================================");

						
						
					}if(select == 6) {
						
						
						ViewAllEmpPro obj = new ViewAllEmpPro();
						obj.viewEmpPro();
						
						System.out.println("===============================================================================");

						
						
						
						
					}
					
					
					else if(select == 7) {
						
						break;
					}else {
						
						System.out.println("select with in the limit...");
						
						System.out.println("===============================================================================");

						
					}
					
					
					
					
				}
				
				
				
				
			}else {
				
				System.out.println("Wrong Credentials.......");
				System.out.println("===============================================================================");

			}
			
		
			
			
			
		}
		else if(choice == 2) {
			
			LoginAsGPMUseCase obj = new LoginAsGPMUseCase();
			
			
			if(obj.loginAsGPM().equals("welcome")) {
				
				while(true) {
					
					
					System.out.println("1. Create Employee.\r\n"
							+ "2. View the Details of Employee.\r\n"
							+ "3. Assign Employee to a Project.\r\n"
							+ "4. View total number of days Employee worked in a project and also their wages.\r\n"
							+ "\r\n"
							+ "5.Break.");
					
					int option = in.nextInt();
					
					if(option==1) {
						
						CreateEmployeeUseCase obj9 = new CreateEmployeeUseCase();
						obj9.createEmp();
						
						System.out.println("===============================================================================");
						
						
					}else if(option==2) {
						
						ViewEmpListUseCase obj10 = new ViewEmpListUseCase();
						
						obj10.viewEmp();
						System.out.println("===============================================================================");

						
					}
					else if(option == 3) {
						
						AssignProjectToEmployeeUseCase obj11 = new AssignProjectToEmployeeUseCase();
						
						obj11.assignEmp();
						System.out.println("===============================================================================");

						
					}
					 
					else if(option == 5) {
						
						break;

					}
					else {
						
						System.out.println("select within the limit....");
						System.out.println("===============================================================================");

					}
					
					
					
					
					
					
					
				}
				
				
				
			}else {
				
				
				
				
				
			}
			
			
			
			
		}
		
		}//WHILE END 
		
		
			
		
		
	}

}
