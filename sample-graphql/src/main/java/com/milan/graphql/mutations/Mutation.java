package com.milan.graphql.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.milan.graphql.dao.PostDao;
import com.milan.graphql.model.Author;
import com.milan.graphql.model.Post;

/**
 * Mutation
 * @author milan
 *
 */
@Service
public class Mutation implements GraphQLMutationResolver {
	@Autowired
    private PostDao postDao;
 
    public Post writePost(String title, String text, String category) {
        return postDao.savePost(title, text, category);
    }
    
    public Post writePost(String title, String text, String category,Author author) {
        return postDao.savePost(title, text, category,author);
    }

}
