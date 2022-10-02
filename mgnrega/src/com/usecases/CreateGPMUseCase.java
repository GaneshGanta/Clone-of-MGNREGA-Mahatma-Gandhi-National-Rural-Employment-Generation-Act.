package com.usecases;

import java.util.Scanner;
import com.dao.*;


public class CreateGPMUseCase {

	public static void createGPM() {
		
		BDODAO bdo = new BDOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter member's name");
		
		String name = sc.nextLine();
		
		System.out.println("Enter memeber's password (max lenght=10)");
		String pass= sc.nextLine();
		
		
		String msg = bdo.createGPM(name, pass); 
		
		System.out.println(msg);

	}

}
