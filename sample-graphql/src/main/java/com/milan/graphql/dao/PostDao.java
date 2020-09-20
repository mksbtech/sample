package com.milan.graphql.dao;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milan.graphql.model.Author;
import com.milan.graphql.model.Data;
import com.milan.graphql.model.Post;

@Service
public class PostDao {
	
	@Autowired
	private Data data;
	
	public List<Post> getRecentPosts(int count,int offset) {
		int lastIndex =  offset+count;
		return data.getPosts().subList(offset,lastIndex);
		
	}

	public Post savePost(String title ,String text,String category) {
		Post post = new Post("100", title, "category"+1);
		data.getPosts().add(post);
		return post;
	}
	
	public Post savePost(String title,String text,String category,Author author) {
//		Post post = new Post("100", "newtitle", "category"+1,author.getId());
		Post post = new Post("100", title, text, category, author.getId());
		if(!data.getAuthorList().contains(author)) {
			data.getAuthorList().add(author);
		}
		data.getPosts().add(post);
		return post;
	}
	
	public Post getPostById(final String postId) {
		
		return data.getPosts().parallelStream().filter(a->a.getId().equals(postId)).collect(Collectors.toList()).get(0);
		
	}
}
