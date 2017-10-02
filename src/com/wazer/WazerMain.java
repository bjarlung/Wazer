package com.wazer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wazer.controller.Controller;
import com.wazer.model.DisplayUtil;
import com.wazer.model.JDBCUtil;

public class WazerMain {

	public static void main(String[] args) {
		new Controller();
		
		
	
		//temp
		try {
			Connection connection = JDBCUtil.getInstance().getConnection();
			Statement statement = connection.createStatement();		
			
			ResultSet resultSet = statement.executeQuery("SELECT* FROM users");
			DisplayUtil.printTable(resultSet);	
			
			resultSet = null;
			
			resultSet = statement.executeQuery("SELECT *FROM posts");
			DisplayUtil.printTable(resultSet);
			
			resultSet = null;
			
			resultSet = statement.executeQuery("SELECT *FROM subject_types");
			DisplayUtil.printTable(resultSet);
			
			resultSet = null;
			statement = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//temp end

	}

	
	
}
