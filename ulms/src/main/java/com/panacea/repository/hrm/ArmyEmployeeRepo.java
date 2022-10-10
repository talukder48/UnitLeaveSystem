package com.panacea.repository.hrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.ArmyEmployee;

public interface ArmyEmployeeRepo extends JpaRepository <ArmyEmployee,String>{
	 @Query(value = "SELECT * FROM `hr_army_employee` WHERE `employee_id`=?1", nativeQuery = true)
	 List<ArmyEmployee> SingleEmployee(String EmployeeId);

}
