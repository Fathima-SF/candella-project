package com.candella.service;

import java.util.List;

import com.candella.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	void save(Employee employee);

}
