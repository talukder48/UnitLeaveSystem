package com.panacea.repository.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.login.UserMaster;

public interface UserMaserRepo extends JpaRepository<UserMaster,String> {
	@Query(value = "SELECT * FROM `user_master` u WHERE u.user_module=?1 and u.activation='A'", nativeQuery = true)
	 List<UserMaster> FindUserListByModule(String Module);

}
