package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "HR_ARMY_EMPLOYEE")
public class ArmyEmployee {
	
	@Id
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	@Column(name = "EmployeeName", length = 200)
	private String EmployeeName;
	@Column(name = "FatherName", length = 200)
	private String FatherName;
	@Column(name = "MotherName", length = 200)
	private String MotherName;
	@Column(name = "Rank", length = 4)
	private String Rank;
	@Column(name = "trade", length = 4)
	private String trade ;
	@Column(name = "company", length = 4)
	private String company;
	@Column(name = "empType", length = 4)
	private String  empType;
	
	
	@Column(name = "bloodGrgp", length = 10)
	private String bloodGrgp;
	@Column(name = "dob", length = 20)
	private String dob;
	@Column(name = "Gender", length = 2)
	private String Gender;
	@Column(name = "EmailAddress", length = 50)
	private String EmailAddress;
	@Column(name = "MobileNo", length = 20)
	private String MobileNo;
	@Column(name = "HomeDistrict", length = 30)
	private String HomeDistrict;
	@Column(name = "livingType", length = 4)
	private String livingType;
	@Column(name = "addres", length = 50)
	private String  addres;
	@Column(name = "maritalStatus", length = 2)
	private String  maritalStatus;
	@Column(name = "fathercontact", length = 15)
	private String fathercontact;
	@Column(name = "altnGurdianName", length = 50)
	private String  altnGurdianName;
	@Column(name = "altnGurdianContact", length = 15)
	private String  altnGurdianContact;
	public ArmyEmployee(String employeeId, String employeeName, String fatherName, String motherName, String rank,
			String trade, String company, String empType, String bloodGrgp, String dob, String gender,
			String emailAddress, String mobileNo, String homeDistrict, String livingType, String addres,
			String maritalStatus, String fathercontact, String altnGurdianName, String altnGurdianContact) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		FatherName = fatherName;
		MotherName = motherName;
		Rank = rank;
		this.trade = trade;
		this.company = company;
		this.empType = empType;
		this.bloodGrgp = bloodGrgp;
		this.dob = dob;
		Gender = gender;
		EmailAddress = emailAddress;
		MobileNo = mobileNo;
		HomeDistrict = homeDistrict;
		this.livingType = livingType;
		this.addres = addres;
		this.maritalStatus = maritalStatus;
		this.fathercontact = fathercontact;
		this.altnGurdianName = altnGurdianName;
		this.altnGurdianContact = altnGurdianContact;
	}
	public ArmyEmployee() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getBloodGrgp() {
		return bloodGrgp;
	}
	public void setBloodGrgp(String bloodGrgp) {
		this.bloodGrgp = bloodGrgp;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getLivingType() {
		return livingType;
	}
	public void setLivingType(String livingType) {
		this.livingType = livingType;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getFathercontact() {
		return fathercontact;
	}
	public void setFathercontact(String fathercontact) {
		this.fathercontact = fathercontact;
	}
	public String getAltnGurdianName() {
		return altnGurdianName;
	}
	public void setAltnGurdianName(String altnGurdianName) {
		this.altnGurdianName = altnGurdianName;
	}
	public String getAltnGurdianContact() {
		return altnGurdianContact;
	}
	public void setAltnGurdianContact(String altnGurdianContact) {
		this.altnGurdianContact = altnGurdianContact;
	}
	

}
