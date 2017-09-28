package com.wazer.controller;

public class Controller {
	private UserController userController;
	
	public Controller() {
		System.out.println("Welcome to Wazer");
		userController = new UserController();
		userController.promptToSignIn();
	}
	

}
