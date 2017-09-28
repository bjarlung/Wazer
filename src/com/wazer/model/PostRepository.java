package com.wazer.model;

public interface PostRepository {
	Post requestPost(int primaryKey);
	Post createPost();
	boolean changePost();
	boolean deletePost(int primaryKey);
	
}
