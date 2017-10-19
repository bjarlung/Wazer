package com.wazer.model;

import java.util.LinkedList;
import java.util.List;

public class User extends Person implements Positionable {
	
	private String username;
	private boolean isLoggedIn;
	private List<Post> postList;
	private Position position;
	
	public User() {
		super();
		postList = new LinkedList<>();
		position = new Position();
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

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(int latitude, int longitude) {
		position.setLatitude(latitude);
		position.setLongitude(longitude);		
	}



}
