package com.wazer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostRepositoryJDBC implements PostRepository{
	
	private Connection connection = JDBCUtil.getInstance().getConnection();
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String INSERT_QUERY = "INSERT INTO posts(header, content, author, type) VALUES(?, ?, ?, ?)";

	@Override
	public Post requestPost(int primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post createPost(String header, String content, int authorId, int typeId) {
		Post post = new Post();
		int id;
		try {			
			prepStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, header);
			prepStatement.setString(2, content);
			prepStatement.setInt(3, authorId);
			prepStatement.setInt(4, typeId);
			id = prepStatement.executeUpdate();	
			System.out.println("Post id: "+ id);
			post = requestPost(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStatement = null;
		
		return post;
	}

	@Override
	public boolean editPost(int postId, String column, String newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(int primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

}
