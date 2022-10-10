package com.panacea.repository.leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.RpRegister;
public interface RpRegisterRepo extends JpaRepository<RpRegister,Long>{
	@Query(value = "SELECT nvl(max(`register_id`),0)+1 FROM `hr_rp_register` WHERE 1", nativeQuery = true)
	 long maxinsertnumber();

}
