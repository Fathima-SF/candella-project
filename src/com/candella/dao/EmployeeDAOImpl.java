package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.Department;
import com.candella.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
public List<Employee> findAll() {
		
		List<Employee> employeeList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from employee";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
					int employeeId = resultSet.getInt(1);
					int departmentId = resultSet.getInt(2);
					String employeeFName = resultSet.getString(3);
					String employeeLName = resultSet.getString(4);
					double salary = resultSet.getDouble(5);
					Department department = new Department();
					department.setDepartmentId(departmentId);
					
					Employee employee = new Employee(employeeId,department,employeeFName,employeeLName,salary);
					employeeList.add(employee);
					
				}
    	}
	   	 catch (SQLException e) {
				e.printStackTrace();
		}
	    finally
		{
			try {
				if(connection!=null)
				connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	    return employeeList;
	}

@Override
	public int save(Employee employee) {
		
	    Connection connection = null; 
		PreparedStatement preparedStatement = null;
		
		final String insertSQL = "insert into employee(emp_firstname,emp_lastname,department_id,salary) "+" values(?,?,?,?)";

	    
	      try 
	      {
	    	  DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement =  connection.prepareStatement(insertSQL);	
			preparedStatement.setString(1, employee.getEmployeeFName());
			preparedStatement.setString(2, employee.getEmployeeLName());
			preparedStatement.setDouble(3, employee.getDepartment().getDepartmentId());
			preparedStatement.setDouble(4, employee.getSalary());
			int row = preparedStatement.executeUpdate();
			return row;
	   }
	      catch (SQLException e) 
		    {
				
				e.printStackTrace();
			}
	      finally {
				try {
					if (connection != null)
						connection.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return 0;
	}
}