package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_ARMY_RANK")
public class ArmyRank {
	@Id
	@Column(name="RankId",length=4)
	private String RankId;
	@Column(name="RankType",length=4)
	private String RankType;
	@Column(name="RankDescription",length=50)
	private String RankDescription;
	
	public ArmyRank(String rankId, String rankType, String rankDescription) {
		super();
		RankId = rankId;
		RankType = rankType;
		RankDescription = rankDescription;
	}
	public ArmyRank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRankId() {
		return RankId;
	}
	public void setRankId(String rankId) {
		RankId = rankId;
	}
	public String getRankType() {
		return RankType;
	}
	public void setRankType(String rankType) {
		RankType = rankType;
	}
	public String getRankDescription() {
		return RankDescription;
	}
	public void setRankDescription(String rankDescription) {
		RankDescription = rankDescription;
	}
	
	
}
