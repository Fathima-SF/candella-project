package com.candella.dao;

import java.util.List;

import com.candella.entity.Department;

public interface DepartmentDAO {

	List<Department> findAll();
	int save(Department department);
	//void update(Department department);
	//void delete(Department department);
	
	
}
