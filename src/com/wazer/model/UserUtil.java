package com.wazer.model;

/**
 * <h1> UserUtil </h1>
 * Makes logged in user available to rest of program
 * @author Beatrice
 *
 */
public class UserUtil {
	private static User activeUser;
	
	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
}
