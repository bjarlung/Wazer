package com.wazer.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * <h1> DisplayUtil </h1>
 * Used to print data from a resultSet
 * @author Beatrice
 *
 */
public class DisplayUtil {
		
	/**
	 * Reads and prints any resultSet to console
	 * @param resultSet
	 */
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
