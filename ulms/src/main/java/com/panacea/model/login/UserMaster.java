package com.panacea.model.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
	@Id
	@Column(name = "UserID", length = 20)
	private String UserID;
	@Column(name = "UserName", length = 50)
	private String UserName;
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	@Column(name = "UserPassword", length = 100)
	private String UserPassword;
	@Column(name = "UserBranch", length = 10)
	private String UserBranch;
	@Column(name = "UserDept", length = 5)
	private String UserDept;
	@Column(name = "UserMobile", length = 15)
	private String UserMobile;
	@Column(name = "UserEmailId", length = 40)
	private String UserEmailId;
	@Column(name = "UserModule", length = 15)
	private String UserModule;
	@Column(name = "UserRole", length = 5)
	private String UserRole;
	@Column(name = "ConPassword", length = 100)
	private String ConPassword;
	@Column(name = "Activation", length = 2)
	private String Activation;
	
	
	public String getActivation() {
		return Activation;
	}

	public void setActivation(String activation) {
		Activation = activation;
	}

	public String getConPassword() {
		return ConPassword;
	}

	public void setConPassword(String conPassword) {
		ConPassword = conPassword;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserBranch() {
		return UserBranch;
	}

	public void setUserBranch(String userBranch) {
		UserBranch = userBranch;
	}

	public String getUserDept() {
		return UserDept;
	}

	public void setUserDept(String userDept) {
		UserDept = userDept;
	}

	public String getUserMobile() {
		return UserMobile;
	}

	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}

	public String getUserEmailId() {
		return UserEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		UserEmailId = userEmailId;
	}

	public String getUserModule() {
		return UserModule;
	}

	public void setUserModule(String userModule) {
		UserModule = userModule;
	}

	

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserMaster(String userID, String userName, String userPassword, String userBranch, String userDept,
			String userMobile, String userEmailId, String userModule, String userRole,String EmployeeId,String Activation) {
		super();
		UserID = userID;
		UserName = userName;
		UserPassword = userPassword;
		UserBranch = userBranch;
		UserDept = userDept;
		UserMobile = userMobile;
		UserEmailId = userEmailId;
		UserModule = userModule;
		UserRole = userRole;
		this.EmployeeId=EmployeeId;
		this.Activation=Activation;
	}
	
	
	

}