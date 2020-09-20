package com.milan.graphql.queries;

import java.util.logging.Logger;

import javax.annotation.Generated;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.milan.graphql.model.Author;
import com.milan.graphql.model.Post;

@Generated(value = "org.junit-tools-1.1.0")
public class PostResolverTest {

	@Generated(value = "org.junit-tools-1.1.0")
	private Logger logger = Logger.getLogger(PostResolverTest.class.toString());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private PostResolver createTestSubject() {
		return new PostResolver();
	}

	
	@Test
	public void testGetAuthor() throws Exception {
		PostResolver testSubject;
		Post post = null;
		Author result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAuthor(post);

		Assert.fail();
	}

	
	@Test
	public void testGetPost() throws Exception {
		PostResolver testSubject;
		Post post = null;
		Post result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPost(post);

		Assert.fail();
	}
}