package com.wazer.controller;

import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.TypeRepository;
import com.wazer.model.TypeRepositoryJDBC;
import com.wazer.model.User;
import com.wazer.model.UserRepository;
import com.wazer.model.UserRepositoryJDBC;
import com.wazer.model.UserUtil;
import com.wazer.view.PositionView;
import com.wazer.view.View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller {
	private LoginController loginController;
	private InputController inputController;

	public Controller() {
		System.out.println("Welcome to Wazer");
		UserRepository userRepo = new UserRepositoryJDBC();
		loginController = new LoginController(userRepo);

		loginController.promptToSignIn();
		User user = UserUtil.getActiveUser();
		
		PostRepository postRepo = new PostRepositoryJDBC();
		TypeRepository typeRepo = new TypeRepositoryJDBC();
			
		inputController = new InputController(user, postRepo, typeRepo, userRepo);

		boolean quit = false;		
		while(!quit) {
			quit = inputController.displayPostMenu();
		}
	}

	public InputController getInputController() {
		return inputController;
	}
	


}
