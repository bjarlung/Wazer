package com.wazer.controller;

import java.util.Scanner;

import com.wazer.model.User;
import com.wazer.model.UserRepository;
import com.wazer.model.UserRepositoryJDBC;

public class LoginController {
	private User activeUser;
	Scanner scanner;
	UserRepository userRepo;

	public LoginController() {
		scanner = new Scanner(System.in);
		userRepo= new UserRepositoryJDBC();
	}

	public User promptToSignIn() {
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("What would you like to do? \n 1. log in \n 2. sign up");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				validChoice = true;
				logIn();
			} else if(input.equals("2")) {
				registerUser();
				validChoice = true;
			}
		}
		return activeUser;
	}

	private void logIn() {
		User user =null;
		while(user == null) {
			System.out.println("Please enter you username: ");
			String username = scanner.nextLine();
			System.out.println("Please enter you password: ");
			String password = scanner.nextLine();
			user = userRepo.getUser(username, password);
		}		
		setActiveUser(user);
		System.out.println(activeUser.getFname() + " " + activeUser.getLname() + ". You have successfully logged in");
	}

	private void registerUser() {

		System.out.println("Enter first name: ");
		String fname = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lname = scanner.nextLine();

		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();

		User user = userRepo.createNewUser(username, password, fname, lname);
		setActiveUser(user);
	}

	public User getActiveUser() {
		return activeUser;
	}

	private void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	


}
