package com.wazer.controller;

import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.TypeRepository;
import com.wazer.model.TypeRepositoryJDBC;
import com.wazer.model.UserRepository;
import com.wazer.model.UserRepositoryJDBC;

/**
 * <h1> Controller </h1>
 * Starts login process and goes on to display input menu.
 * @author Beatrice
 *
 */
public class Controller {
	private LoginController loginController;
	private InputController inputController;
	
	/**
	 * Initiates database repositories and controllers.
	 * Gets user to sign in. Displays menu to user.
	 */
	public Controller() {
		System.out.println("Welcome to Wazer");
		UserRepository userRepo = new UserRepositoryJDBC();
		loginController = new LoginController(userRepo);

		loginController.promptToSignIn();
		
		PostRepository postRepo = new PostRepositoryJDBC();
		TypeRepository typeRepo = new TypeRepositoryJDBC();
			
		inputController = new InputController(postRepo, typeRepo, userRepo);

		boolean quit = false;		
		while(!quit) {
			quit = inputController.displayPostMenu();
		}
	}

	public InputController getInputController() {
		return inputController;
	}
	


}
