package com.panacea.repository.hrm;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.ArmyRank;

public interface ArmyRankRepo extends JpaRepository <ArmyRank,String>{
	@Query(value = "SELECT `rank_description` FROM `hr_army_rank` WHERE `rank_id`=?1", nativeQuery = true)
	 String FindRank(String RankId);

}
