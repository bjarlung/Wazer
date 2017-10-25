package com.wazer.model;

/**
 * <h1> Person </h1>
 * Superclass to User.
 * @author Beatrice
 *
 */
public class Person {
	private int id;
	private String fname;
	private String lname;
	
	public Person() {}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
