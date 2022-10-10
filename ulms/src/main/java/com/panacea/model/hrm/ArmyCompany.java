package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_ARMY_COMPANY")
public class ArmyCompany {
	@Id
	@Column(name="CompanyId",length=4)
	private String CompanyId;
	@Column(name="CompanyDescription",length=50)
	private String CompanyDescription;
	public String getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}
	public String getCompanyDescription() {
		return CompanyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		CompanyDescription = companyDescription;
	}
	public ArmyCompany() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArmyCompany(String companyId, String companyDescription) {
		super();
		CompanyId = companyId;
		CompanyDescription = companyDescription;
	}
	
	
}
