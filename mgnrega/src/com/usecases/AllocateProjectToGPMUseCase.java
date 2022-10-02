package com.usecases;

import java.util.Scanner;
import com.dao.*;
import com.exceptions.*;



public class AllocateProjectToGPMUseCase {
	
	
	public static void allocateGPM() {
		
		
		Scanner sc = new Scanner(System.in);
		
		BDODAO bdo = new BDOImpl(); 
		
		System.out.println("Enter Project Id");
		int pid = sc.nextInt();
		System.out.println("Enter gram panchayat member Id");
		int gid = sc.nextInt();
		
		try {
			
			String msg = bdo.allocateProjectGpm(gid,pid);
			System.out.println(msg);
			
		} catch (ProjectException | GPMException e) {
			
			System.out.println(e.getMessage());
		
		
		}
	}
	
}
