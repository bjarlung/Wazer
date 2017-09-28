package com.wazer.model;

public interface UserRepository {
	User getUser(String username, String password);
	User createNewUser(String username, String password, String fname, String lname);
	boolean editUser();
	boolean deleteUser(int primaryKey);
	
}
