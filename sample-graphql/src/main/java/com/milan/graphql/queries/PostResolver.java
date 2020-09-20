package com.milan.graphql.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.milan.graphql.dao.AuthorDao;
import com.milan.graphql.dao.PostDao;
import com.milan.graphql.model.Author;
import com.milan.graphql.model.Post;

/**
 * Field resolver
 * @author milan
 *
 */
@Service
public class PostResolver implements GraphQLResolver<Post> {
	@Autowired
    private AuthorDao authorDao;
	
	@Autowired
	private PostDao postDao;
 
    public Author getAuthor(Post post) {
        return authorDao.getAuthorById(post.getAuthorId());
    }
    
    public Post getPost(Post post) {
        return postDao.getPostById(post.getId());
    }

}
