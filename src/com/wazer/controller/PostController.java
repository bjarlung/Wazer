package com.wazer.controller;

import java.util.List;
import java.util.Scanner;

import com.wazer.model.Post;
import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.TypeRepository;
import com.wazer.model.TypeRepositoryJDBC;
import com.wazer.model.User;


public class PostController {

	Scanner scanner;
	PostRepository postRepo;
	TypeRepository typeRepo;
	User user;

	public PostController(User user) {
		scanner = new Scanner(System.in);
		postRepo = new PostRepositoryJDBC();
		typeRepo = new TypeRepositoryJDBC();
		this.user = user;
	}

	public boolean displayPostMenu() {
		boolean quit = false;
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("What would you like to do? \n 1. Write new post \n 2. Edit post \n 3. Read post \n 4. Quit \n");
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
				quit = true;
				validChoice = true;
			} else {
				System.out.println("Not a valid choice. Please try again.");
			}
		} 	
		return quit;
	}

	private void readPost() {
		boolean isValid = false;
		String input = "";
		while(!isValid) {
			//TODO enter username
			System.out.println("Enter the id of the person whose posts you would like to read: ");
			input = scanner.nextLine();
			isValid = checkIfInt(input);
		}
		postRepo.requestPostByUser(Integer.parseInt(input));
	}

	private void createNewPost() {
		System.out.println("Header: ");
		String header = scanner.nextLine();
		System.out.println("Content: ");
		String content = scanner.nextLine();	

		int authorId = user.getId();
		System.out.println("ID author: "+ authorId);

		int postId = postRepo.createPost(header, content, authorId);

		int typeId = getType();
		postRepo.addType(postId, typeId);
	}

	private int getType() {
		System.out.println("Type: ");
		String input = scanner.nextLine();
		int id = typeRepo.createType(input);	
		return id;
	}

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

	public List<Post> getUsersPosts() {
		return null;
	}

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
