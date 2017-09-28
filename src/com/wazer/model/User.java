package com.wazer.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{
	
	private String username;
	private boolean isLoggedIn;
	private List<Post> postList;
	
	public User() {
		super();
		postList = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}



}
