package com.wazer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryJDBC implements PostRepository{

	private Connection connection;
	private PreparedStatement prepStatement;
	private Statement statement;
	private ResultSet resultSet;
	private static final String INSERT_QUERY = "CALL insert_post(?, ?, ?)"; //insert_post(header, content, author)
	private static final String REQUEST_BY_ID = "SELECT * FROM posts WHERE post_id=?";
	private static final String REQUEST_BY_USER = "SELECT post_id, header, content, type FROM posts WHERE author=?";  //TODO view -join with type
	private static final String GET_ID = "SELECT LAST_INSERT_ID()";
	private static final String UPDATE_TYPE = "UPDATE posts SET type=? WHERE post_id=?";
	private static final String UPDATE_CONTENT = "UPDATE posts SET content=? WHERE post_id=?";
	private static final String DELETE_QUERY = "DELETE FROM posts WHERE post_id=?";

	public PostRepositoryJDBC() {
		connection = JDBCUtil.getInstance().getConnection();
	}

	@Override
	public Post requestPost(int primaryKey) {
		try {
			prepStatement = connection.prepareStatement(REQUEST_BY_ID);
			prepStatement.setInt(1, primaryKey);
			resultSet = prepStatement.executeQuery();
			printTable(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Integer> requestPostByUser(int userId) {
		//TODO request by username, join users+posts
		
		List<Integer> postIdList = new ArrayList<>();
		try {
			prepStatement = connection.prepareStatement(REQUEST_BY_USER);
			prepStatement.setInt(1, userId);
			resultSet = prepStatement.executeQuery();
			printTable(resultSet);

			
			resultSet.beforeFirst();
			while(resultSet.next()) {
				Integer id = (Integer)resultSet.getInt("post_id");
				postIdList.add(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return postIdList;
	}

	private void printTable(ResultSet resultSet) {
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


	@Override
	public int createPost(String header, String content, int authorId) {
		int id = 0;
		int affectedRows;
		try {			
			prepStatement = connection.prepareStatement(INSERT_QUERY);
			prepStatement.setString(1, header);
			prepStatement.setString(2, content);
			prepStatement.setInt(3, authorId);
			affectedRows = prepStatement.executeUpdate();
			if(affectedRows > 0) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(GET_ID);
				resultSet.next();
				id = resultSet.getInt("LAST_INSERT_ID()");
				System.out.println("Post id: "+ id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;
		return id;
	}

	@Override
	public boolean editPost(int postId, String column, String newValue) {
		if(column.equals("content")) {
			editContent(postId, newValue);
			requestPost(postId);
			return true;
		}

		return false;
	}

	private boolean editContent(int postId, String newValue) {
		boolean successful = false;
		int affectedRows;
		try {			
			prepStatement = connection.prepareStatement(UPDATE_CONTENT);
			prepStatement.setString(1, newValue);
			prepStatement.setInt(2, postId);

			affectedRows = prepStatement.executeUpdate();
			if(affectedRows > 0) {
				successful = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;
		return successful;
			
	}

	@Override
	public boolean deletePost(int primaryKey) {
		boolean deleted = false;
		int affectedRows;
		try {			
			prepStatement = connection.prepareStatement(DELETE_QUERY);
			prepStatement.setInt(1, primaryKey);

			affectedRows = prepStatement.executeUpdate();
			if(affectedRows > 0) {
				deleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;	

		return deleted;
	}

	@Override
	public boolean addType(int postId, int typeId) {
		boolean successful = false;
		int affectedRows;
		try {			
			prepStatement = connection.prepareStatement(UPDATE_TYPE);
			prepStatement.setInt(1, typeId);
			prepStatement.setInt(2, postId);

			affectedRows = prepStatement.executeUpdate();
			if(affectedRows > 0) {
				successful = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;
		return successful;
	}



}
