package com.panacea.repository.hrm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.ArmyCompany;

public interface ArmyCompayRepo extends JpaRepository<ArmyCompany,String> {
	@Query(value = "SELECT `company_description` FROM `hr_army_company` WHERE `company_id`=?1", nativeQuery = true)
	 String findcomapny(String company);
}
