package com.wazer.controller;

import java.util.List;
import java.util.Scanner;

import com.wazer.WazerMain;
import com.wazer.model.PostRepository;
import com.wazer.model.TypeRepository;
import com.wazer.model.User;
import com.wazer.model.UserRepository;
import com.wazer.model.UserUtil;

/**
 * <h1> InputController </h1>
 * Connects user with the database
 * @author Beatrice
 *
 */
public class InputController {
	private Scanner scanner;
	private PostRepository postRepo;
	private TypeRepository typeRepo;
	private UserRepository userRepo;
	private User user;

	/**
	 * Sets variables, initiates scanner, gets active user.
	 * @param postRepo
	 * @param typeRepo
	 * @param userRepo
	 */
	public InputController(PostRepository postRepo, TypeRepository typeRepo, UserRepository userRepo) {
		scanner = new Scanner(System.in);
		this.postRepo = postRepo;
		this.typeRepo = typeRepo;
		this.userRepo = userRepo;
		user = UserUtil.getActiveUser();
	}

	/**
	 * Prompts user to write posts, edit, read, or find friends.
	 * @return quit
	 */
	public boolean displayPostMenu() {
		boolean quit = false;
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("What would you like to do? \n 1. Write new post \n 2. Edit post "
					+ "\n 3. Read post \n 4. Find friends \n 5. Quit \n");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				createNewPost();
				validChoice = true;
			} else if(input.equals("2")) {
				promptToEdit();
				validChoice = true;
			} else if(input.equals("3")) {
				readPost();
				validChoice = true;
			} else if(input.equals("4")) {
				promtForSearch();							
				validChoice = true;
			} else if(input.equals("5")) {
				quit = true;
				validChoice = true;
			} else {
				System.out.println("Not a valid choice. Please try again.");
			}
		} 	
		return quit;
	}
	
	/**
	 * Asks user for input and displays users from database accordingly.
	 */
	private void promtForSearch() {
		System.out.println("Who are you looking for? ");
		String input = scanner.nextLine();
		userRepo.displayUsers(input);
	}
	
	/**
	 * Activates GUI
	 */
	private void readPost() {
		if (!WazerMain.getIsInit()) {
			WazerMain.launch(WazerMain.class, WazerMain.getArgs());
			WazerMain.setIsInit(true);
		}
		else {
			System.out.println("Sorry, cannot reenter the GUI");
		}
	}
	
	/**
	 * Creates new post in database after input from user. 
	 */
	private void createNewPost() {
		System.out.println("Header: ");
		String header = scanner.nextLine();
		System.out.println("Content: ");
		String content = scanner.nextLine();	

		int authorId = user.getId();
		System.out.println("ID author: "+ authorId);
		int latitude = promptForPosition("Latitude");
		int longitude = promptForPosition("Longitude");

		int postId = postRepo.createPost(header, content, authorId, latitude, longitude);

		int typeId = getType();
		postRepo.addType(postId, typeId);
	}

	/**
	 * Asks user for a position to place the post at.
	 * @param latOrLong
	 * @return
	 */
	private int promptForPosition(String latOrLong) {
		int inputInt = 0;
		boolean isValid = false;
		while(!isValid) {
			System.out.println(latOrLong + " of your post. Between 0 and 4");
			String input = scanner.nextLine();
			if(validatePosition(input)) {
				isValid = true;
				inputInt = Integer.parseInt(input);
			}	
		}
		return inputInt;
	}
	
	/**
	 * Checks if the input is an int within the specified range
	 * @param input
	 * @return
	 */
	private boolean validatePosition(String input) {
		boolean isValid = false;
		if(!checkIfInt(input)) {
			return false;
		}
		int inputAsInt = Integer.parseInt(input);
		if(inputAsInt < 5 && inputAsInt >= 0) {
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Asks user to specify genre of post.
	 * @return
	 */
	private int getType() {
		System.out.println("Type: ");
		String input = scanner.nextLine();
		int id = typeRepo.createType(input);	
		return id;
	}

	/**
	 * Displays users post and asks for an id.
	 */
	private void promptToEdit() {
		System.out.println("Your posts:");
		List<Integer> editablePostList = postRepo.requestPostByUser(user.getId());
		boolean isInt = false;
		String input = "";
		while(!isInt) {
			System.out.println("Please print the id of the post you would like to change");
			input = scanner.nextLine();
			isInt = checkIfInt(input);
		}
		Integer inputAsInt = Integer.parseInt(input);
		if(editablePostList.contains(inputAsInt)) {
			promptForEditChoice(inputAsInt);		
		} else {
			System.out.println("Sorry you cannot edit this post.");
		}
	}
	
	/**
	 * Asks user to specify whether to delete or change a post.
	 * @param postId
	 */
	private void promptForEditChoice(int postId) {
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("Would you like to \n 1. Change this post? \n 2. Delete this post");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				changePost(postId);
				validChoice = true;
			} else if(input.equals("2")) {
				postRepo.deletePost(postId);
				validChoice = true;
			} else {
				System.out.println("Not a valid choice. Please try again");
			}
		}
	}
	
	/**
	 * Asks the user to edit content or type of post.
	 * @param postId
	 */
	private void changePost(int postId) {
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("Would you like to \n 1. Edit content \n 2. Change subject type");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				System.out.println("New content: ");
				String contentInput = scanner.nextLine();
				postRepo.editPost(postId, "content", contentInput);				
				validChoice = true;
			} else if(input.equals("2")) {
				int typeId = getType();
				postRepo.addType(postId, typeId);
				validChoice = true;
			} else {
				System.out.println("Not a valid choice. Please try again");
			}
		}
	}

	/**
	 * Validates whether a string is parsable to an int
	 * @param input
	 * @return isInt, boolean
	 */
	private boolean checkIfInt(String input){
		boolean isInt = false;
		try {
			Integer.parseInt(input);
			isInt = true;
		}catch(Exception e){
			System.out.println("Not a number, try again.");
		}
		return isInt;
	}

}
