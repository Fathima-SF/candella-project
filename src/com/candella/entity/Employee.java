package com.candella.entity;

public class Employee {

	private int employeeId;
	private Department department; //HAS A 
	private String employeeFName;
	private String employeeLName;
	private double salary;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, Department department, String employeeFName, String employeeLName, double salary) {
		super();
		this.employeeId = employeeId;
		this.department = department;
		this.employeeFName = employeeFName;
		this.employeeLName = employeeLName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmployeeFName() {
		return employeeFName;
	}

	public void setEmployeeFName(String employeeFName) {
		this.employeeFName = employeeFName;
	}

	public String getEmployeeLName() {
		return employeeLName;
	}

	public void setEmployeeLName(String employeeLName) {
		this.employeeLName = employeeLName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
