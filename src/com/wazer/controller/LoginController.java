package com.wazer.controller;

import java.util.Scanner;

import com.wazer.model.User;
import com.wazer.model.UserRepository;
import com.wazer.model.UserUtil;
/**
 * <h1> LoginController </h1>
 * Prompt user to log in or sign up.
 * @author Beatrice
 *
 */
public class LoginController {
	Scanner scanner;
	UserRepository userRepo;

	public LoginController(UserRepository userRepo) {
		scanner = new Scanner(System.in);
		this.userRepo= userRepo;
	}
	/**
	 * Prompts user to sign in or register. Calling methods contacting database
	 */
	public void promptToSignIn() {
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
	}
	
	/**
	 * Asks user for username and password. Gets user from database and sets to active.
	 */
	private void logIn() {
		User user =null;
		while(user == null) {
			System.out.println("Please enter you username: ");
			String username = scanner.nextLine();
			System.out.println("Please enter you password: ");
			String password = scanner.nextLine();
			user = userRepo.getUser(username, password);
		}
		activateUser(user);
	}

	/**
	 * Asks user for data and creates new user in database. Activates user.
	 */
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
		activateUser(user);
	}

	private void activateUser(User user) {
		UserUtil.setActiveUser(user);
		User activeUser = UserUtil.getActiveUser();
		System.out.println(activeUser.getFname() + " " + activeUser.getLname() + ". You have successfully logged in");	
	}

}
