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

public class DepartmentDAOImpl implements DepartmentDAO {

		@Override
		public List<Department> findAll() {
			List<Department> departmentList = new ArrayList();
			Connection connection = null;
			PreparedStatement prepStmt = null;

			String selectSQL = "Select * from department";
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				prepStmt = connection.prepareStatement(selectSQL);
				ResultSet resultSet = prepStmt.executeQuery();
				while (resultSet.next()) {
					int departmentId = resultSet.getInt(1);
					String departmentName = resultSet.getString(2);
					String departmentType = resultSet.getString(3);
					String location = resultSet.getString(4);
					Department department = new Department(departmentId, departmentName, departmentType, location);
					departmentList.add(department);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return departmentList;

		}

	@Override
	public int save(Department department) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into department(department_id,department_name,department_type,location) values(?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, department.getDepartmentId());
			preparedStatement.setString(2, department.getDepartmentName());
			preparedStatement.setString(3, department.getDepartmentType());
			preparedStatement.setString(4, department.getLocation());
			int row = preparedStatement.executeUpdate();
			return row;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

}
