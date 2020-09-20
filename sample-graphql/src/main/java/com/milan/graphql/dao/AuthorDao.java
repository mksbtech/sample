package com.milan.graphql.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milan.graphql.model.Author;
import com.milan.graphql.model.Data;

@Service
public class AuthorDao {
	@Autowired
	private Data data;
	
	public Author getAuthorById(final String authorId) {
		
		return data.getAuthorList().parallelStream().filter(a->a.getId().equals(authorId)).collect(Collectors.toList()).get(0);
		
	}
	
	public List<Author> getAuthors(int count,int offset) {
		
		return data.getAuthorList().subList(offset, offset+count);
		
	}
}
