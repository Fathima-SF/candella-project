package com.candella.service;

import java.util.List;

import com.candella.entity.Department;

public interface DepartmentService {
	
	List<Department> findAll();
	void save(Department department);

}
