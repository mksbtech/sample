package com.milan.graphql.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Data {

	private List<Author> authorList;
	private List<Post> posts;
	
	@PostConstruct
	public void initiatilize() {
		authorList = new ArrayList<>();
		posts = new ArrayList<>();
		Author author = null;
		Post post = null;
		for(int i=0;i<10;i+=1) {
			author = new Author(""+i,"firstName"+i,"lastName"+i);
			post = new Post(""+i, "title"+i, "category"+i, author.getId());
			authorList.add(author);
			posts.add(post);
		}
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
