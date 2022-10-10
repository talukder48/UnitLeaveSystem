package com.panacea.model.login;

public class DropDownType {
private String typeKey;
private String typeValue;
public DropDownType() {
	super();
	// TODO Auto-generated constructor stub
}
public String getTypeKey() {
	return typeKey;
}
public void setTypeKey(String typeKey) {
	this.typeKey = typeKey;
}
public String getTypeValue() {
	return typeValue;
}
public void setTypeValue(String typeValue) {
	this.typeValue = typeValue;
}
public DropDownType(String typeKey, String typeValue) {
	super();
	this.typeKey = typeKey;
	this.typeValue = typeValue;
}

}
