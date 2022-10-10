package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_LEAVE_DESCRIPTION")
public class LeaveDescription {
	@Id
	@Column(name="LeaveCode",length=4)
	private String LeaveCode;
	@Column(name="LeaveDescription",length=50)
	private String LeaveDescription;
	public LeaveDescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveDescription(String leaveCode, String leaveDescription) {
		super();
		LeaveCode = leaveCode;
		LeaveDescription = leaveDescription;
	}
	public String getLeaveCode() {
		return LeaveCode;
	}
	public void setLeaveCode(String leaveCode) {
		LeaveCode = leaveCode;
	}
	public String getLeaveDescription() {
		return LeaveDescription;
	}
	public void setLeaveDescription(String leaveDescription) {
		LeaveDescription = leaveDescription;
	}
	
}
