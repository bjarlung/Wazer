package com.wazer.model;

/**
 * <h1> UserRepository Interface </h1>
 * Interface determining interaction between program and database
 * @author Beatrice
 *
 */
public interface UserRepository {
	User getUser(String username, String password);
	User createNewUser(String username, String password, String fname, String lname);
	boolean editUser();
	boolean deleteUser(int primaryKey);
	void displayUsers(String searchString);
}
