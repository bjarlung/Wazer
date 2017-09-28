package com.wazer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.wazer.controller.Controller;
import com.wazer.model.JDBCUtil;

public class WazerMain {

	public static void main(String[] args) {
		new Controller();
		
		
		
		
		//temp
		try {
			Connection connection = JDBCUtil.getInstance().getConnection();
			Statement statement = connection.createStatement();		
			String sqlQuery = "SELECT* FROM users";
			
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			printTable(resultSet);
				
			resultSet = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//temp end

	}

	
	
	
	//temp metod för att kolla db
	public static void printTable(ResultSet resultSet) {
		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
				
			int columnsNumber = metaData.getColumnCount();
			for(int i= 1; i<=columnsNumber; i++) {
				System.out.print(metaData.getColumnName(i)+ " | ");
			}
			System.out.println("");
			
			while(resultSet.next()) {
				for(int i= 1; i<=columnsNumber; i++) {
					System.out.print(resultSet.getString(i)+ " | ");
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
