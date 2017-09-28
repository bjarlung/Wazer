package com.wazer.controller;

import java.util.List;
import java.util.Scanner;

import com.wazer.model.Post;
import com.wazer.model.PostRepository;
import com.wazer.model.PostRepositoryJDBC;
import com.wazer.model.User;


public class PostController {
	
	Scanner scanner;
	PostRepository postRepo;
	User user;
	
	public PostController(User user) {
		scanner = new Scanner(System.in);
		postRepo= new PostRepositoryJDBC();
		this.user = user;
	}
	
	public void displayMenu() {
		
		boolean validChoice = false;
		while(!validChoice) {
			System.out.println("What would you like to do? \n 1. Write new post \n 2. Edit post 3. Read post");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				createNewPost();
				validChoice = true;
			} else if(input.equals("2")) {
				editPost();
				validChoice = true;
			} else if(input.equals("3")) {
				readPost();
				validChoice = true;
			}
		} 
		
	}
	
	private void readPost() {
		
		
	}

	private void createNewPost() {
		System.out.println("Header: ");
		String header = scanner.nextLine();
		System.out.println("Content: ");
		String content = scanner.nextLine();

		System.out.println("Type: ");
		int typeId = getType(scanner.nextLine());
		
		int authorId = user.getId();
		
		postRepo.createPost(header, content, authorId, typeId);
	}
	
	private int getType(String nextLine) {
		// TODO 
		return 0;
	}

	private void editPost() {
		
	}
	
	public List<Post> getUsersPosts() {
		return null;
	}
}
