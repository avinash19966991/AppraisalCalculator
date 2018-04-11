package com.wipro.performance.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.entity.Service;

public class MainClass {
	public static void main(String [] args) throws ParseException {
		EmployeeBean ebean=new EmployeeBean();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		//Date todayDate = dateFormatter.parse(dateFormatter.format(new Date()));
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ADID--> ");
		ebean.setADID(sc.next());
		//sc.next();
		System.out.println("Enter Employee Name--> ");
		sc.next();
		ebean.setEmpName(sc.nextLine());
		
		System.out.println("Enter Business Unit--> ");
		ebean.setBusinessUnit(sc.next());
		
		System.out.println("Enter Date of Joining--> ");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		String cindate = sc.next();
	    Date doj = myFormat.parse(cindate);
		ebean.setDateOfJoining(doj);
		
		System.out.println("Enter Current Salary--> ");
		ebean.setCurrentSalary((float)sc.nextFloat());
		
		System.out.println("Enter Total Attendance--> ");
		ebean.setTotalAttendance((float)sc.nextFloat());
		
		System.out.println("Enter Manager Rating--> ");
		ebean.setManagerRating((float)sc.nextFloat());
		
		
		String result=Service.getAppraisalDetails(ebean);
		System.out.println(result);
	}
	
	
	
	
}
