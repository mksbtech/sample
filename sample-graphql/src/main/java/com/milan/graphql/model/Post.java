package com.milan.graphql.model;

public class Post {
	private String id;
    private String title;
    private String text;
    private String category;
    private String authorId;
    
    
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Post(String id, String title, String category, String authorId) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.authorId = authorId;
	}

	

	public Post(String id, String title, String text, String category, String authorId) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.category = category;
		this.authorId = authorId;
	}


	public Post(String id, String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
    
}
