package com.rec.demo.dto;

public class EmployeeDTO {

	private String employeeNumber;

	private String personTypeName;

	private String businessGroupOrganizationName;

	private String locationName;

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(final String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getPersonTypeName() {
		return personTypeName;
	}

	public void setPersonTypeName(final String personTypeName) {
		this.personTypeName = personTypeName;
	}

	public String getBusinessGroupOrganizationName() {
		return businessGroupOrganizationName;
	}

	public void setBusinessGroupOrganizationName(String businessGroupOrganizationName) {
		this.businessGroupOrganizationName = businessGroupOrganizationName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
