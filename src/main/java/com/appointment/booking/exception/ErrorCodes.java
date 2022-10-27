package com.appointment.booking.exception;

public enum ErrorCodes {
INTERNAL_ERROR("Some Internal Error at the moment"),
SYS_TECH_ERROR("System is under Maintenance"),
APP_DATE_MANDATORY("Appointment Date Mandatory"),
MANDATORY_FIELD("Mandatory Field Missing"),
TO_DATE_FROM("To Date cannot be before From Date");
private String code;
private String desc;
private ErrorCodes(String desc) {
	this.code = name();
	this.desc = desc;
}
private ErrorCodes(String codes, String description) {
	this.code = codes;
	this.desc = desc;
}
public String getCodes() {
	return code;
}
public String getDescription() {
	return desc;
}

}
