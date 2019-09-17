package com.coderby.myapp.hr.model;

import java.sql.Date;

public class EmpVO {
	
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private String jobId;
	
	private int managerId;
	
	private int departmentId;
	
	private Date hireDate;
	
	private double salary;
	
	private double commissionPct;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	@Override
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", jobId=" + jobId + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + "]";
	}

}
