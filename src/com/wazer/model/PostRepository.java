package com.wazer.model;

import java.util.List;

/**
 * <h1> PostRepository Interface </h1>
 * Interface determining interaction between program and database
 * @author Beatrice
 *
 */
public interface PostRepository {
	Post requestPost(int primaryKey);
	List<Integer> requestPostByUser(int userId);
	List<Post> requestPostByPosition(Position position);
	int createPost(String header, String content, int authorId, int latitude, int longitude);
	boolean editPost(int postId, String column, String newValue);
	boolean deletePost(int primaryKey);
	boolean addType(int postId, int typeId);
}
