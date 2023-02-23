package com.candella.entity;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private String departmentType;
	private String location;
	
	public Department(int departmentId, String departmentName, String departmentType, String location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentType = departmentType;
		this.location = location;
	}
	

	public Department() {
		
	}


	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
