package com.milan.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration;

//@SpringBootApplication(exclude = {
//		GraphQLWebAutoConfiguration.class
//		})
@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

}
