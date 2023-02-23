package com.candella.service;

import java.util.List;

import com.candella.dao.DepartmentDAOImpl;
import com.candella.entity.Department;

public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public List<Department> findAll() {
		
		DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
		List<Department> departmentList = departmentDAOImpl.findAll();
		return departmentList;
	}

	@Override
	public void save(Department department) {

		DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
		int row = departmentDAOImpl.save(department);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

}
