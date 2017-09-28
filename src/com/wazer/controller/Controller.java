package com.wazer.controller;

import com.wazer.model.User;

public class Controller {
	private UserController userController;
	private PostController postController;
	
	public Controller() {
		System.out.println("Welcome to Wazer");
		userController = new UserController();
		
		
		userController.promptToSignIn();
		User user = userController.getActiveUser();
		
		postController = new PostController(user);
		
		
		//TODO get the users posts, set to List
		
		
		postController.displayMenu();
		
				
	}
	

}
