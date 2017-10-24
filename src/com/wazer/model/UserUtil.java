package com.wazer.model;

public class UserUtil {
	private static User activeUser;
	
	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
}
