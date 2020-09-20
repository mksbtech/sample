package com.milan.graphql.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.milan.graphql.dao.AuthorDao;
import com.milan.graphql.dao.PostDao;
import com.milan.graphql.model.Author;
import com.milan.graphql.model.Post;

/**
 * Query Resolver
 * @author milan
 *
 */
@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
    private PostDao postDao;
	
	@Autowired
	private AuthorDao authorDao;
	
    public List<Post> getPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
    
    public List<Author> getAuthors(int count, int offset) {
        return authorDao.getAuthors(count,offset);
    }
}
