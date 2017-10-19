package com.wazer.model;

public class Post implements Positionable{
	private int postId;
	private String header;
	private String content;
	private User author;
	private SubjectType subjectType;
	private Position position;
	
	public Post() {
		position = new Position();
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(int latitude, int longitude) {
		position.setLatitude(latitude);
		position.setLongitude(longitude);		
	}
	
	
}
