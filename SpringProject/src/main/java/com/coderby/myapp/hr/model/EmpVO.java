package com.coderby.myapp.hr.model;

import java.sql.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmpVO {

	@Min(value = 207, message = "사원번호는 207이상" )
	private int employeeId;

	@Pattern(regexp = "[a-zA-Z가-힣]{1,}", message = "이름 입력")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z가-힣]{1,}", message = "성 입력")
	private String lastName;

	@Pattern(regexp = "[A-Z0-9]{2,}", message = "영문 대문자와 숫자를 이용해 두자리 이상")
	private String email;

	@Pattern(regexp = "^[0-9]{2,3}[-\\.]?[0-9]{3,4}[-\\.]?[0-9]{4}$", message = "유효한 전화번호가 아님")
	private String phoneNumber;
	
	private Date hireDate;

	private String jobId;

	@Digits(integer=6, fraction=2, message="잘못된 급여액")
	private double salary;

	@DecimalMin(value="0.00", message = "보너스율 >= 0.0")
	@DecimalMax(value="0.99", message = "보너스율 < 1")
	private double commissionPct;

	private int managerId;

	private int departmentId;

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
