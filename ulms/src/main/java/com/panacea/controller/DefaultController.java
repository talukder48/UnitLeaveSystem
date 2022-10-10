package com.panacea.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.panacea.model.hrm.ArmyCompany;
import com.panacea.model.hrm.ArmyEmployee;
import com.panacea.model.hrm.ArmyRank;
import com.panacea.model.hrm.ArmyTrade;
import com.panacea.model.hrm.Employee;
import com.panacea.model.hrm.LeaveDescription;
import com.panacea.model.login.UserMaster;

import com.panacea.repository.hrm.*;
import com.panacea.repository.leave.*;
import com.panacea.utils.AESEncrypt;

@Controller
public class DefaultController {
   
    @Autowired
	LeaveRegisterRepo leaveregisterRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	UserMaserRepo UserMasterRepo;
	
	@GetMapping("/DefaultUserCreation")
	public String DefaultUserCreation() {
		if (UserMasterRepo.count() == 0) {
			List<UserMaster> UserList = new ArrayList<UserMaster>();
			UserList.add(new UserMaster("10000", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "SYSTEM","S","","A"));
			UserList.add(new UserMaster("20001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","E","","A"));
			UserList.add(new UserMaster("20002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","S","","A"));
			UserList.add(new UserMaster("30001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "E","","A"));
			UserList.add(new UserMaster("30002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "S","","A"));
			UserList.add(new UserMaster("40001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "LEAVE","M","","A"));
			UserList.add(new UserMaster("40002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "LEAVE","E","","A"));
			UserList.add(new UserMaster("50001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "HRM","S","","A"));
			UserList.add(new UserMaster("60001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","S","","A"));
			UserList.add(new UserMaster("60002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","E","","A"));
			
			UserMasterRepo.saveAll(UserList);
		}
		return "index";
	}

	
	@GetMapping("/DefaultEmployeeInsert")
	public String DefaultEmployeeInsert() {
		
		if (employeeRepo.count() == 0) {
			List <Employee> EmployeeList = new ArrayList<Employee>() ;
			EmployeeList.add(new Employee("ID2020080002","Abu Tayab","Abdur Rahim","Amena Begum","199210000001","1098234567","M","test@gmail.com","017120908902","Barisal","01-01-2009","20"));	
			EmployeeList.add(new Employee("ID2020080001","Abdur Rahim","Abdur Karim","Momena Begum","199210003001","1098231567","M","test@gmail.com","017120908902","Feni","01-01-2009","19"));	
			EmployeeList.add(new Employee("ID2020080003","Tanjila Akter","Abdur Rob","Jorina Begum","199210004001","1098232567","M","test@gmail.com","017120908902","Rangamati","01-01-2009","18"));	
			EmployeeList.add(new Employee("ID2020080005","Habibur Rahman","Aminur Rahmna","Maymuna Begum","199210080001","4098234567","M","test@gmail.com","017120908902","Dhaka","01-01-2009","17"));	
			employeeRepo.saveAll(EmployeeList);
		}
		return "index";
	}
	

    
  
    
    @Autowired
    ArmyCompayRepo ArmyCompayRepo;
    @Autowired
    ArmyRankRepo ArmyRankRepo;
    @Autowired
    ArmyTradeRepo ArmyTradeRepo;
    @Autowired
	ArmyEmployeeRepo ArmyEmployeeRepo;
    @Autowired
    LeaveDescriptionRepo LeaveDescriptionRepo;
  
    
    @GetMapping("/DefaultLeaveParameterCreation")
   	public String DefaultParameterCreation() {
   		if (ArmyCompayRepo.count() == 0) {
   			List <ArmyCompany> ArmyCompanyList = new ArrayList<ArmyCompany>() ;
   			ArmyCompanyList.add(new ArmyCompany("000","Not Applicable"));
   			ArmyCompanyList.add(new ArmyCompany("101","BHQ"));	
   			ArmyCompanyList.add(new ArmyCompany("102","HQ Company"));	
   			ArmyCompanyList.add(new ArmyCompany("103","OP Company"));	
   			ArmyCompanyList.add(new ArmyCompany("104","RR Company"));	
   			ArmyCompanyList.add(new ArmyCompany("105","Radio Company"));	
   			ArmyCompanyList.add(new ArmyCompany("106","BSC"));
   			ArmyCompanyList.add(new ArmyCompany("107","ABSC"));
   			ArmyCompayRepo.saveAll(ArmyCompanyList);
   		}
   		if (ArmyRankRepo.count() == 0) {
   			List <ArmyRank> ArmyRankList = new ArrayList<ArmyRank>() ;
   			ArmyRankList.add(new ArmyRank("101","OFFR","Second Lieutenant"));	
   			ArmyRankList.add(new ArmyRank("102","OFFR","Lieutenant"));	
   			ArmyRankList.add(new ArmyRank("103","OFFR","Captain"));	
   			ArmyRankList.add(new ArmyRank("104","OFFR","Major"));	
   			ArmyRankList.add(new ArmyRank("105","OFFR","Lieutenant Colonel"));	
   			ArmyRankList.add(new ArmyRank("106","OFFR","Honorary captain"));
   			
   			ArmyRankList.add(new ArmyRank("201","JCO","Honorary Lieutenant"));
   			ArmyRankList.add(new ArmyRank("202","JCO","Master Warrant Officer"));
   			ArmyRankList.add(new ArmyRank("203","JCO","Senior Warrant officer"));
   			ArmyRankList.add(new ArmyRank("204","JCO","Warrant Officer"));
   			
   			ArmyRankList.add(new ArmyRank("301","OR","Corporal"));
   			ArmyRankList.add(new ArmyRank("302","OR","Lance Corporal"));
   			ArmyRankList.add(new ArmyRank("303","OR","Sainik"));
   			ArmyRankList.add(new ArmyRank("304","OR","NC(E)"));
   			ArmyRankRepo.saveAll(ArmyRankList);
   		}
   		if (ArmyTradeRepo.count() == 0) {
   			List <ArmyTrade> ArmyTradeList = new ArrayList<ArmyTrade>() ;
   			ArmyTradeList.add(new ArmyTrade("000","Not Applicable"));	
   			ArmyTradeList.add(new ArmyTrade("101","Operator"));	
   			ArmyTradeList.add(new ArmyTrade("102","Technician"));	
   			ArmyTradeList.add(new ArmyTrade("103","W/S"));	
   			ArmyTradeList.add(new ArmyTrade("104","DTMN"));	
   			ArmyTradeList.add(new ArmyTrade("105","Driver"));	
   			ArmyTradeList.add(new ArmyTrade("106","Clerk"));
   			ArmyTradeList.add(new ArmyTrade("107","SMT"));
   			ArmyTradeRepo.saveAll(ArmyTradeList);
   		}
	   	 if (ArmyEmployeeRepo.count() == 0) {
	 		List <ArmyEmployee> ArmyEmployeeList = new ArrayList<ArmyEmployee>() ;
	 		ArmyEmployeeList.add(new ArmyEmployee("50001","Mr. Rubel","Abdur Rahim","Amena Begum","101","101","101","O","A+","01-01-1991","M","test@gmail.com","017120908902","Barisal","10","Wirless Gate","M","01515222234","Abu Naser","01515222235"));	

	 		ArmyEmployeeRepo.saveAll(ArmyEmployeeList);
	 	}
	   	if (LeaveDescriptionRepo.count() == 0) {
   			List <LeaveDescription> LeavList = new ArrayList<LeaveDescription>() ;
   			LeavList.add(new LeaveDescription("C","Casual leave"));	
   			LeavList.add(new LeaveDescription("R","Recreation leave"));	
   			LeavList.add(new LeaveDescription("P","Privilege leave"));	
   			LeavList.add(new LeaveDescription("F","Festival leave"));	
   			LeavList.add(new LeaveDescription("E","Emergency leave"));	
   			LeavList.add(new LeaveDescription("W","Weekend"));
   			LeaveDescriptionRepo.saveAll(LeavList);
   		}
	   	if (UserMasterRepo.count() == 0) {
			List<UserMaster> UserList = new ArrayList<UserMaster>();
			UserList.add(new UserMaster("50001", "Mr. Rubel", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "LEAVE","S","50001","A"));
			
			UserMasterRepo.saveAll(UserList);
		}
	   	
	   	
	   	 
   		return "index";
   	}   
   
    
    
}
