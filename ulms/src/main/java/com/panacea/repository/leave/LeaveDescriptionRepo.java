package com.panacea.repository.leave;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.LeaveDescription;
public interface LeaveDescriptionRepo extends JpaRepository<LeaveDescription,String> {
	@Query(value = "SELECT `leave_description` FROM `hr_leave_description` WHERE `leave_code`=?1", nativeQuery = true)
	 String FindLeaveDescription(String LeaveCode);
}
