package com.panacea.repository.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.LeaveRegister;
public interface LeaveRegisterRepo extends JpaRepository<LeaveRegister,Long> {
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is null and r.reject_by is null and r.approve_by is null and `rank_code` like ?1", nativeQuery = true)
	 List<LeaveRegister> FindJCOToRecomended(String Prefix);
	 
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is null and r.reject_by is null and r.approve_by is null and `rank_code` not like ?1", nativeQuery = true)
	 List<LeaveRegister> FindOfficierToRecomended(String Prefix);
	 
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is not null and r.reject_by is null and r.approve_by is  null", nativeQuery = true)
	 List<LeaveRegister> FindToBeApprovalList();
	 
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is not null and r.reject_by is null and r.approve_by is not null and `check_out_status` not like '%Returned From Leave%' ", nativeQuery = true)
	 List<LeaveRegister> AuthorizedList();
	 
	 
	 @Query(value = "select * from `hr_leave_register` r where r.employee_id =?1", nativeQuery = true)
	 List<LeaveRegister> FindAppliedList(String EmployeeId);
	 
}
