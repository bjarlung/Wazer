package com.wazer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TypeRepositoryJDBC implements TypeRepository{
	
	private Connection connection;
	private PreparedStatement prepStatement;
	private Statement statement;
	private ResultSet resultSet;
	private static final String INSERT_QUERY = "INSERT INTO subject_types(type_name) VALUES(?)";
	//private static final String REQUEST_QUERY = "SELECT type_name FROM subject_types WHERE type_id=?";
	private static final String REQUEST_ID_QUERY = "SELECT type_id FROM subject_types WHERE type_name=?";
	private static final String GET_ID = "SELECT LAST_INSERT_ID()";
	

	public TypeRepositoryJDBC() {
		connection = JDBCUtil.getInstance().getConnection();
	}

	@Override
	public SubjectType requestType(int primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int createType(String typeName) {
		int id = 0;
		int affectedRows;
		try {			
			prepStatement = connection.prepareStatement(INSERT_QUERY);
			prepStatement.setString(1, typeName);
			affectedRows = prepStatement.executeUpdate();
			if(affectedRows > 0) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(GET_ID);
				resultSet.next();
				id = resultSet.getInt("LAST_INSERT_ID()");
				System.out.println("Type id: "+ id);			
			}
		} catch (SQLException e) {
			prepStatement = null;
			id = requestId(typeName);
		}
		prepStatement = null;
		return id;
	}
	

	private int requestId(String typeName) {
		int id = 0;
		try {
			prepStatement = connection.prepareStatement(REQUEST_ID_QUERY);
			prepStatement.setString(1, typeName);
			resultSet = prepStatement.executeQuery();
			resultSet.next();
			id = resultSet.getInt("type_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return id;
	}

	@Override
	public boolean editType(int typeId, String nameNew) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteType(int primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

}
