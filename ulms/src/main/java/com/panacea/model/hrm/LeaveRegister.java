package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_LEAVE_REGISTER")
public class LeaveRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "LeaveID", length = 20)
	private Long LeaveID;
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	@Column(name = "EmployeeName", length = 200)
	private String EmployeeName;
	@Column(name = "LeaveType", length = 2)
	private String LeaveType;
	@Column(name = "Location", length = 50)
	private String Location;
	@Column(name = "StartDate", length = 20)
	private String StartDate;
	@Column(name = "EndDate", length = 20)
	private String EndDate;
	@Column(name = "LeaveReason", length = 200)
	private String LeaveReason;
	@Column(name = "ApplyDate", length = 20)
	private String ApplyDate;

	@Column(name = "leaveStatus", length = 40)
	private String leaveStatus;
	@Column(name = "RecomendBy", length = 20)
	private String RecomendBy;
	@Column(name = "RecomendOn", length = 20)
	private String RecomendOn;
	@Column(name = "RecomendRemarks", length = 200)
	private String RecomendRemarks;
	@Column(name = "IntmedBy", length = 20)
	private String IntmedBy;
	@Column(name = "Intmedon", length = 20)
	private String Intmedon;
	@Column(name = "IntmedRemarks", length = 200)
	private String IntmedRemarks;
	@Column(name = "approveBy", length = 20)
	private String approveBy;
	@Column(name = "approveOn", length = 20)
	private String approveOn;
	@Column(name = "ApprovedRemarks", length = 200)
	private String ApprovedRemarks;
	@Column(name = "RejectBy", length = 20)
	private String RejectBy;
	@Column(name = "RejectOn", length = 20)
	private String RejectOn;
	@Column(name = "RankCode", length = 5)
	private String RankCode;
	
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
	@Column(name = "CheckOutStatus", length = 80)
	private String CheckOutStatus;
	
	

	public String getCheckOutStatus() {
		return CheckOutStatus;
	}

	public void setCheckOutStatus(String checkOutStatus) {
		CheckOutStatus = checkOutStatus;
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

	public LeaveRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveRegister(Long leaveID, String employeeId, String employeeName, String leaveType, String location,
			String startDate, String endDate, String leaveReason, String applyDate,String RankCode) {
		super();
		LeaveID = leaveID;
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		LeaveType = leaveType;
		Location = location;
		StartDate = startDate;
		EndDate = endDate;
		LeaveReason = leaveReason;
		ApplyDate = applyDate;
		this.RankCode=RankCode;
	}

	public String getRankCode() {
		return RankCode;
	}

	public void setRankCode(String rankCode) {
		RankCode = rankCode;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public Long getLeaveID() {
		return LeaveID;
	}

	public void setLeaveID(Long leaveID) {
		LeaveID = leaveID;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
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

	public String getLeaveReason() {
		return LeaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		LeaveReason = leaveReason;
	}

	public String getApplyDate() {
		return ApplyDate;
	}

	public void setApplyDate(String applyDate) {
		ApplyDate = applyDate;
	}

	public String getRecomendBy() {
		return RecomendBy;
	}

	public void setRecomendBy(String recomendBy) {
		RecomendBy = recomendBy;
	}

	public String getRecomendOn() {
		return RecomendOn;
	}

	public void setRecomendOn(String recomendOn) {
		RecomendOn = recomendOn;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public String getApproveOn() {
		return approveOn;
	}

	public void setApproveOn(String approveOn) {
		this.approveOn = approveOn;
	}

	public String getRejectBy() {
		return RejectBy;
	}

	public void setRejectBy(String rejectBy) {
		RejectBy = rejectBy;
	}

	public String getRejectOn() {
		return RejectOn;
	}

	public void setRejectOn(String rejectOn) {
		RejectOn = rejectOn;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getRecomendRemarks() {
		return RecomendRemarks;
	}

	public void setRecomendRemarks(String recomendRemarks) {
		RecomendRemarks = recomendRemarks;
	}

	public String getIntmedBy() {
		return IntmedBy;
	}

	public void setIntmedBy(String intmedBy) {
		IntmedBy = intmedBy;
	}

	public String getIntmedon() {
		return Intmedon;
	}

	public void setIntmedon(String intmedon) {
		Intmedon = intmedon;
	}

	public String getIntmedRemarks() {
		return IntmedRemarks;
	}

	public void setIntmedRemarks(String intmedRemarks) {
		IntmedRemarks = intmedRemarks;
	}

	public String getApprovedRemarks() {
		return ApprovedRemarks;
	}

	public void setApprovedRemarks(String approvedRemarks) {
		ApprovedRemarks = approvedRemarks;
	}

}
