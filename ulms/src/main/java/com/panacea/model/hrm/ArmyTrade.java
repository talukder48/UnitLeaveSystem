package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_ARMY_TRADE")
public class ArmyTrade {
	@Id
	@Column(name="TradeId",length=4)
	private String TradeId;
	@Column(name="TradeDescription",length=50)
	private String TradeDescription;
	public ArmyTrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArmyTrade(String tradeId, String tradeDescription) {
		super();
		TradeId = tradeId;
		TradeDescription = tradeDescription;
	}
	public String getTradeId() {
		return TradeId;
	}
	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}
	public String getTradeDescription() {
		return TradeDescription;
	}
	public void setTradeDescription(String tradeDescription) {
		TradeDescription = tradeDescription;
	}
	
}
