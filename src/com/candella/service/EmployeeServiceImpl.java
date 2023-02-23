package com.candella.service;

import java.util.List;

import com.candella.dao.DepartmentDAOImpl;
import com.candella.dao.EmployeeDAOImpl;
import com.candella.entity.Department;
import com.candella.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> findAll() {
		
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		List<Employee> employeeList = employeeDAOImpl.findAll();
		return employeeList;
		
	}

	@Override
	public void save(Employee employee) {

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		int row = employeeDAOImpl.save(employee);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

}
