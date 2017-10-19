package com.wazer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryJDBC implements UserRepository{
	private Connection connection = JDBCUtil.getInstance().getConnection();
	private PreparedStatement prepStatement;
	private static final String LOG_IN_QUERY = "SELECT user_id, fname, lname FROM users WHERE username=? AND password=?";
	private static final String NEW_USER_QUERY = "INSERT INTO users(username, password, fname, lname) VALUES(?, ?, ?, ?)";
	private Statement statement;
	private ResultSet resultSet;

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {			
			System.out.println(connection);
			prepStatement = connection.prepareStatement(LOG_IN_QUERY);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			resultSet = prepStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.first();
				user = new User();
				user.setFname(resultSet.getString("fname"));
				user.setLname(resultSet.getString("lname"));
				user.setUsername(username);
				user.setId(resultSet.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resultSet = null;
		prepStatement = null;
		return user;
	}

	@Override
	public User createNewUser(String username, String password, String fname, String lname) {
		try {			
			prepStatement = connection.prepareStatement(NEW_USER_QUERY);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			prepStatement.setString(3, fname);
			prepStatement.setString(4, lname);
			prepStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;
		User user = getUser(username, password);
		return user;
	}

	@Override
	public boolean editUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayUsers(String searchString) {
		String query ="SELECT user_id, username, fname, lname FROM users WHERE fname LIKE '"
				+ searchString + "%' OR lname LIKE '" + searchString +"%'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);		
			DisplayUtil.printTable(resultSet);					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
