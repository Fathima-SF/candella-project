package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.dao.EmployeeDAOImpl;
import com.candella.entity.Department;
import com.candella.entity.Employee;
import com.candella.service.DepartmentServiceImpl;
import com.candella.service.EmployeeServiceImpl;

public class EmployeeUtility {

	public static void main(String[] args) {
		
		getAllEmployee();

		insertIntoEmployee();
	
	}

	private static void getAllEmployee() {
		
		EmployeeServiceImpl employeeserviceImpl = new EmployeeServiceImpl();
		List<Employee> employeetList = employeeserviceImpl.findAll();
		display();
		for (Employee employee : employeetList) {
			
			System.out.println(employee.getEmployeeId()+"          "+ employee.getEmployeeFName() + "           " + employee.getEmployeeLName() + "           "
					+ employee.getDepartment().getDepartmentId() + "          " + employee.getSalary());
		}
	}

	private static void insertIntoEmployee() {
		
		System.out.println("---------------------------------------------------------------------------");
		DepartmentUtility.getAllDepartment();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Employeee***********************");
		System.out.println("Enter the DepartmentID:");
		int departmentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Employee Firstname:");
		String employeeFirstName = scanner.nextLine();
		System.out.println("Enter the Employee Secondname:");
		String employeeLastName = scanner.nextLine();
		System.out.println("Enter the salary:");
		double salary = scanner.nextDouble();
	

	    Employee employee = new Employee();
		//Setting department id to employee
		Department department = new Department();
		department.setDepartmentId(departmentId);
		employee.setDepartment(department);
		
		employee.setEmployeeFName(employeeFirstName);
		employee.setEmployeeLName(employeeLastName);
		employee.setSalary(salary);
		
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		employeeServiceImpl.save(employee);
	}
	
	private static void display() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Employee_id\temp_firstname\temp_lastname\tdepartment_id\tsalary");
		System.out.println("--------------------------------------------------------------------");

		
	}

}
