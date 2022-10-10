package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "HR_RP_REGISTER")
public class RpRegister {
	
	@Id
	@Column(name = "RegisterId", length = 10)
	Long RegisterId;
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	
	@Column(name = "EmployeeName", length = 20)
	private String EmployeeName;
	
	@Column(name = "LeaveID", length = 20)
	private Long LeaveID;
	@Column(name = "LeaveDate", length = 20)
	private String LeaveDate;
	@Column(name = "ReturnDate", length = 20)
	private String ReturnDate;
	@Column(name = "Remarks", length = 200)
	private String Remarks;
	@Column(name = "StartDate", length = 20)
	private String StartDate;
	@Column(name = "EndDate", length = 20)
	private String EndDate;
	@Column(name = "Vill", length = 100)
	private String Vill;
	@Column(name = "Post", length = 100)
	private String Post;
	@Column(name = "PoliceStation", length = 100)
	private String PoliceStation;
	@Column(name = "District", length = 50)
	private String District;
	@Column(name = "Place", length = 100)
	private String Place;
	@Column(name = "RankName", length = 80)
	private String RankName;
	@Column(name = "CheckOutType", length = 5)
	private String CheckOutType;
	@Column(name = "EntyBy", length = 20)
	private String EntyBy;
	@Column(name = "EntyOn", length = 20)
	private String EntyOn;
	
	
	
	public RpRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getEmployeeName() {
		return EmployeeName;
	}


	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}


	public String getEntyBy() {
		return EntyBy;
	}


	public void setEntyBy(String entyBy) {
		EntyBy = entyBy;
	}


	public String getEntyOn() {
		return EntyOn;
	}


	public void setEntyOn(String entyOn) {
		EntyOn = entyOn;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}


	public String getCheckOutType() {
		return CheckOutType;
	}


	public void setCheckOutType(String checkOutType) {
		CheckOutType = checkOutType;
	}


	public String getVill() {
		return Vill;
	}


	public void setVill(String vill) {
		Vill = vill;
	}


	public String getPost() {
		return Post;
	}


	public void setPost(String post) {
		Post = post;
	}


	public String getPoliceStation() {
		return PoliceStation;
	}


	public void setPoliceStation(String policeStation) {
		PoliceStation = policeStation;
	}


	public String getDistrict() {
		return District;
	}


	public void setDistrict(String district) {
		District = district;
	}


	public String getPlace() {
		return Place;
	}


	public void setPlace(String place) {
		Place = place;
	}


	public String getRankName() {
		return RankName;
	}


	public void setRankName(String rankName) {
		RankName = rankName;
	}


	public Long getRegisterId() {
		return RegisterId;
	}
	public void setRegisterId(Long registerId) {
		RegisterId = registerId;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public Long getLeaveID() {
		return LeaveID;
	}
	public void setLeaveID(Long leaveID) {
		LeaveID = leaveID;
	}
	public String getLeaveDate() {
		return LeaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		LeaveDate = leaveDate;
	}
	public String getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	} 
	
	
	
	
	
	
}
