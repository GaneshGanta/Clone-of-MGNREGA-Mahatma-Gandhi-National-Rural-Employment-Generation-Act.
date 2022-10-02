package com.usecases; 

import java.util.InputMismatchException;
import com.dao.*;
import java.util.Scanner;

import com.dao.GPMDAO;
import com.dao.GPMIMPL;
import com.exceptions.GPMException;
import com.beanClasses.GPM;
import com.connection.*;
import com.dao.*;

public class LoginAsGPMUseCase {
	public static String loginAsGPM() {
		
		
		GPMDAO gmp = new GPMIMPL();
		Scanner sc = new Scanner(System.in);
		
		String ans = null;
		
		try {
			
			
			try {
				
				System.out.println("Enter your Id");
				int id = sc.nextInt();
				System.out.println("Enter your password");
				sc.nextLine();
				String pass = sc.nextLine();
				
				 ans = gmp.loginAsGPM(id, pass);
				
			
			} catch (GPMException e) {
				
				System.out.println(e.getMessage());
				System.out.println("please try again"); 
				
			}
		
		}catch(InputMismatchException ime) {
			
			System.out.println("Please enter valid ID");
			loginAsGPM();
			
		}
		
		return ans; 
		
	}
}
