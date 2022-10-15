package com.panacea.repository.hrm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.ArmyTrade;

public interface ArmyTradeRepo extends JpaRepository <ArmyTrade,String>{
	@Query(value = "SELECT `trade_description` FROM `hr_army_trade` WHERE `trade_id`=?1", nativeQuery = true)
	 String FindTrade(String RankId);
}
