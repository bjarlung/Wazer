package com.wazer.model;

public interface PostRepository {
	Post requestPost(int primaryKey);
	Post createPost(String header, String content, int authorId, int typeId);
	boolean editPost(int postId, String column, String newValue);
	boolean deletePost(int primaryKey);
}
