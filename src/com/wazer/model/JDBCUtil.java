package com.wazer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	private Connection connection;
	private static JDBCUtil instance;
	
	private static final String URL = "jdbc:mysql://localhost:3306/wazer";
	private static final String USER = "root";
	private static final String PASS = "";
	
	
	private JDBCUtil() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static JDBCUtil getInstance(){
		if(instance == null) {
			instance = new JDBCUtil();
		}
		return instance;
		
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
