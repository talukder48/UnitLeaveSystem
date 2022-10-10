package com.panacea.repository.leave;


import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.hrm.LeaveDescription;
public interface LeaveDescriptionRepo extends JpaRepository<LeaveDescription,String> {
	
}
