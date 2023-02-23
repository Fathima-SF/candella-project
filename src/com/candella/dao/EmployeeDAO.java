package com.candella.dao;

import java.util.List;

import com.candella.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	int save(Employee employee);
}
