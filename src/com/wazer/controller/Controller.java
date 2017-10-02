package com.wazer.controller;

import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.TypeRepository;
import com.wazer.model.TypeRepositoryJDBC;
import com.wazer.model.User;
import com.wazer.model.UserRepository;
import com.wazer.model.UserRepositoryJDBC;

public class Controller {
	private LoginController loginController;
	private InputController inputController;

	public Controller() {
		System.out.println("Welcome to Wazer");
		UserRepository userRepo = new UserRepositoryJDBC();
		loginController = new LoginController(userRepo);

		loginController.promptToSignIn();
		User user = loginController.getActiveUser();
		
		PostRepository postRepo = new PostRepositoryJDBC();
		TypeRepository typeRepo = new TypeRepositoryJDBC();
		inputController = new InputController(user, postRepo, typeRepo, userRepo);


		//TODO get the users posts, set to List ??
		
		boolean quit = false;		
		while(!quit) {
			quit = inputController.displayPostMenu();
		}


	}


}
