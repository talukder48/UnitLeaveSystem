package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	@Column(name = "EmployeeName", length = 200)
	private String EmployeeName;
	@Column(name = "FatherName", length = 200)
	private String FatherName;
	@Column(name = "MotherName", length = 200)
	private String MotherName;
	@Column(name = "NID", length = 20)
	private String NID;
	@Column(name = "TIN", length = 15)
	private String TIN;
	@Column(name = "Gender", length = 2)
	private String Gender;
	@Column(name = "EmailAddress", length = 50)
	private String EmailAddress;
	@Column(name = "MobileNo", length = 20)
	private String MobileNo;
	@Column(name = "HomeDistrict", length = 30)
	private String HomeDistrict;
	@Column(name = "JoinDate", length = 20)
	private String JoinDate;
	@Column(name = "Designation", length = 4)
	private String Designation;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String employeeName, String fatherName, String motherName, String nID,
			String tIN, String gender, String emailAddress, String mobileNo, String homeDistrict, String joinDate,
			String designation) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		FatherName = fatherName;
		MotherName = motherName;
		NID = nID;
		TIN = tIN;
		Gender = gender;
		EmailAddress = emailAddress;
		MobileNo = mobileNo;
		HomeDistrict = homeDistrict;
		JoinDate = joinDate;
		Designation = designation;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getMotherName() {
		return MotherName;
	}
	public void setMotherName(String motherName) {
		MotherName = motherName;
	}
	public String getNID() {
		return NID;
	}
	public void setNID(String nID) {
		NID = nID;
	}
	public String getTIN() {
		return TIN;
	}
	public void setTIN(String tIN) {
		TIN = tIN;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getHomeDistrict() {
		return HomeDistrict;
	}
	public void setHomeDistrict(String homeDistrict) {
		HomeDistrict = homeDistrict;
	}
	public String getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	
	
	
}
