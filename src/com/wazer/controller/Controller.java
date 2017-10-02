package com.wazer.controller;

import com.wazer.model.User;

public class Controller {
	private LoginController loginController;
	private PostController postController;

	public Controller() {
		System.out.println("Welcome to Wazer");
		loginController = new LoginController();


		loginController.promptToSignIn();
		User user = loginController.getActiveUser();

		postController = new PostController(user);


		//TODO get the users posts, set to List ??
		
		boolean quit = false;		
		while(!quit) {
			quit = postController.displayPostMenu();
		}


	}


}
