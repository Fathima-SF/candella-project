package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Department;
import com.candella.service.DepartmentServiceImpl;

/*********
 * 
 * @author Fathima SF
 *
 */
public class DepartmentUtility {

	public static void main(String[] args) {

		getAllDepartment();
		insertIntoDepartment();

	}
	/*****
	 * To get all departments from the department table
	 */

	public static void getAllDepartment() {

		DepartmentServiceImpl departmentSErviceImple = new DepartmentServiceImpl();
		List<Department> departmentList = departmentSErviceImple.findAll();
		for (Department department : departmentList) {
			System.out.println(department.getDepartmentId() + "   " + department.getDepartmentName() + "   "
					+ department.getDepartmentType() + "  " + department.getLocation());
		}
	}

	public static void insertIntoDepartment() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Department***********************");
		System.out.println("Enter the DepartmentID:");
		int departmentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Departmentname:");
		String departmentName = scanner.nextLine();
		System.out.println("Enter the Departmenttype:");
		String departmentType = scanner.nextLine();
		System.out.println("Enter the Location:");
		String location = scanner.nextLine();
		Department department = new Department(departmentId,departmentName,departmentType,location);
		DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
		departmentService.save(department);
		
	}

	

}
