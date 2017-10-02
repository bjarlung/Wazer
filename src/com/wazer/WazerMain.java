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
			
			ResultSet resultSet = statement.executeQuery("SELECT* FROM users");
			printTable(resultSet);	
			
			resultSet = null;
			
			resultSet = statement.executeQuery("SELECT *FROM posts");
			printTable(resultSet);
			
			resultSet = null;
			
			resultSet = statement.executeQuery("SELECT *FROM subject_types");
			printTable(resultSet);
			
			resultSet = null;
			statement = null;
			
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
		System.out.println(System.getProperty("line.separator"));

	}
}
