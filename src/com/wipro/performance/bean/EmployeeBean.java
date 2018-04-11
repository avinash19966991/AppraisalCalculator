package com.wipro.performance.bean;

import java.util.Date;

public class EmployeeBean {
	private String ADID;
	private String empName;
	private String businessUnit;
	private Date dateOfJoining;
	private float currentSalary;
	private float totalAttendance;
	private float managerRating;
	public String getADID() {
		return ADID;
	}
	public void setADID(String aDID) {
		ADID = aDID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public float getCurrentSalary() {
		return currentSalary;
	}
	public void setCurrentSalary(float currentSalary) {
		this.currentSalary = currentSalary;
	}
	public float getTotalAttendance() {
		return totalAttendance;
	}
	public void setTotalAttendance(float totalAttendance) {
		this.totalAttendance = totalAttendance;
	}
	public float getManagerRating() {
		return managerRating;
	}
	public void setManagerRating(float managerRating) {
		this.managerRating = managerRating;
	}
	public EmployeeBean(String ADID, String empName, String businessUnit, Date dateOfJoining, float currentSalary,
			float totalAttendance, float managerRating) {
		super();
		this.ADID = ADID;
		this.empName = empName;
		this.businessUnit = businessUnit;
		this.dateOfJoining = dateOfJoining;
		this.currentSalary = currentSalary;
		this.totalAttendance = totalAttendance;
		this.managerRating = managerRating;
	}
	public EmployeeBean() {
		this.ADID ="";
		this.empName = "";
		this.businessUnit = "";
		this.dateOfJoining = new Date();
		this.currentSalary = 0.0f;
		this.totalAttendance = 0.0f;
		this.managerRating = 0.0f;
	}
	
	
}
