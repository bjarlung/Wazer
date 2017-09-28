package com.wazer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryJDBC implements UserRepository{
	private Connection connection = JDBCUtil.getInstance().getConnection();
	private PreparedStatement prepStatement;
	private static final String LOG_IN_QUERY = "SELECT fname, lname FROM users WHERE username=? AND password=?";
	private static final String NEW_USER_QUERY = "INSERT INTO users(username, password, fname, lname) VALUES(?, ?, ?, ?)";
	private ResultSet resultSet;

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {			
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
				//user.setId(resultSet.getInt("user_id"));
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

}
