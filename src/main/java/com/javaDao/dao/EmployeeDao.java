package com.javaDao.dao;
//data acess object layer
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javaBean.bean.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employees" + 
				" (id, first_name, last_name, month, day, year, address, city, state, postal_code, phone, email, linkedin, motivation_letter) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "lifeisgood");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirst_name());
			preparedStatement.setString(3, employee.getLast_name());
			preparedStatement.setString(4, employee.getMonth());
			preparedStatement.setString(5, employee.getDay());
			preparedStatement.setString(6, employee.getYear());
			preparedStatement.setString(7, employee.getAddress());
			preparedStatement.setString(8, employee.getCity());
			preparedStatement.setString(9, employee.getState());
			preparedStatement.setString(10, employee.getPostal_code());
			preparedStatement.setString(11, employee.getPhone());
			preparedStatement.setString(12, employee.getEmail());
			preparedStatement.setString(13, employee.getLinkedin());
			preparedStatement.setString(14, employee.getMotivation_letter());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	//handling exceptions
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
