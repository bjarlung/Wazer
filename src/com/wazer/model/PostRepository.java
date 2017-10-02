package com.wazer.model;

import java.util.List;

public interface PostRepository {
	Post requestPost(int primaryKey);
	List<Integer> requestPostByUser(int userId);
	int createPost(String header, String content, int authorId);
	boolean editPost(int postId, String column, String newValue);
	boolean deletePost(int primaryKey);
	boolean addType(int postId, int typeId);
}
