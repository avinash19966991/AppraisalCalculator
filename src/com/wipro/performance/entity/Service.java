package com.wipro.performance.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

public class Service {
	
	public static String validateData(EmployeeBean ebean) throws ParseException {
		String ADID=ebean.getADID();
		String empName=ebean.getEmpName();
		String bu=ebean.getBusinessUnit();
		Date doj=ebean.getDateOfJoining();
		float currentSalary=ebean.getCurrentSalary();
		float totalAttendance=ebean.getTotalAttendance();
		float managerRating=ebean.getManagerRating();
		
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(ADID);
		String msg="";
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date todayDate = dateFormatter.parse(dateFormatter.format(new Date()));
		
		if(!(ADID.length()==6 && matcher.matches())) {
			msg=new InvalidADIDException().toString();
		}
		else if(!(bu.equalsIgnoreCase("JAVA") || bu.equalsIgnoreCase("Oracle") || 
				bu.equalsIgnoreCase("BigData"))) {
			
			msg=new InvalidBUException().toString();
			
		}
		
		
		else if(doj.equals(todayDate) || doj.after(todayDate)) {
			
			msg=new InvalidDOJException().toString();
			
		}
		else if(currentSalary<50000) {
			msg=new InvalidCurrentSalaryException().toString();
		}
		else if(!(totalAttendance>=0.0f && totalAttendance<=200.0f)) {
			msg="Invalid Attendance";
		}
		else if(!(managerRating>0.0f && managerRating<5.0f)) {
			msg="Invalid Rating";
		}
		else {
			msg="SUCCESS";
		}
		return msg;
	}
	
	public static String computeAppraisal(EmployeeBean ebean) throws ParseException {
		String msg=validateData(ebean);
		if(msg.equalsIgnoreCase("Success")) {
			float totalAttendance=ebean.getTotalAttendance();
			float currentSalary=ebean.getCurrentSalary();
			float managerRating=ebean.getManagerRating();
			
			float hike1 = 0.0f,hike2 = 0.0f;
			if(totalAttendance>=0 && totalAttendance<=100) {
				hike1=0.0f;
			}
			else if(totalAttendance>=101 && totalAttendance<=150) {
				hike1=0.05f*currentSalary;
			}
			else if(totalAttendance>=151 && totalAttendance<=200) {
				hike1=0.06f*currentSalary;
			}
			
			if(managerRating==5.0f) {
				hike2=0.10f*currentSalary;
			}
			else if(managerRating==4.0f) {
				hike2=0.09f*currentSalary;
			}
			else if(managerRating==3.0f) {
				hike2=0.08f*currentSalary;
			}
			else if(managerRating==2.0f) {
				hike2=0.07f*currentSalary;
			}
			else if(managerRating==1.0f) {
				hike2=0.06f*currentSalary;
			}
			else if(managerRating==0.0f) {
				hike2=0.0f*currentSalary;
			}
			
			return Float.toString(currentSalary+hike1+hike2);
		}
		else {
			return msg;
		}
	}
	
	public static String getAppraisalDetails(EmployeeBean ebean) throws NumberFormatException, ParseException {
		float sal=0.0f;
		String msg=computeAppraisal(ebean);
		try {
			sal=Float.parseFloat(msg);
			ebean.setCurrentSalary(sal);
			return ebean.getADID()+":"+sal;	
		}
		catch(Exception e) {
			return ebean.getADID()+":"+msg;
		}
	}
	
}

















