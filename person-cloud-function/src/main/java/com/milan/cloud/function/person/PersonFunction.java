package com.milan.cloud.function.person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import com.milan.cloud.function.vo.PersonVO;
import com.milan.cloud.function.vo.Result;

@SpringBootApplication
@ComponentScan(value = { "com.milan.cloud" })
public class PersonFunction {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String BASE_PERSON_URI = "http://localhost:8080/person/";
	public static void main(String [] args) {
		SpringApplication.run(PersonFunction.class, args);
	}
	
	/**
	 * Get endpoint with url /person-function/persons/
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@Bean(name="persons")
	@RequestScope
	public Function<String, List<PersonVO>> getAllPersons() throws IOException{		
		HttpEntity entity = new HttpEntity(getHttpHeaders());
		ResponseEntity<List<PersonVO>> respEntity = (ResponseEntity<List<PersonVO>>) getRestTemplate().exchange(BASE_PERSON_URI+"findAllPerson", HttpMethod.GET, entity, new ArrayList<PersonVO>().getClass());
		System.out.println(respEntity.getHeaders());
		Function<String, List<PersonVO>> functionResult= null;		
			final List<PersonVO> result = respEntity.getBody();
			functionResult= (v)-> {
				return result;
				};
				return functionResult;
	}
	
	/**
	 * Post endpoint with url http://localhost:8081/person-function/person
	 * @body {"firstName": "First Name","lastName": "Last Name"}
	 * @return
	 */
	@Bean(name="person")
	public Function<PersonVO,String> createPerson(){

		return personVO -> {
			if(null ==personVO || personVO.getFirstName()==null || personVO.getLastName()==null) {
				return "Invalid input";}
			
			HttpEntity<PersonVO> entity = new HttpEntity<PersonVO>(personVO, getHttpHeaders());
			
			ResponseEntity<Result> respEntity = (ResponseEntity<Result>) getRestTemplate().exchange(BASE_PERSON_URI+"person", HttpMethod.POST, entity, Result.class);
				final Result result = respEntity.getBody();				
					return result.getMessage();
		};		
	}
	
	/**
	 * Post endpoint with url http://localhost:8081/person-function/updatePerson
	 * @body {"firstName": "First Name","lastName": "Last Name"}
	 * @return
	 */
	@Bean(name="updatePerson")
	public Function<PersonVO,String> updatePerson(){

		return personVO -> {
			if(null ==personVO || personVO.getFirstName()==null || personVO.getLastName()==null) {
				return "Invalid input";}
			
			HttpEntity<PersonVO> entity = new HttpEntity<PersonVO>(personVO, getHttpHeaders());
			
			ResponseEntity<Result> respEntity = (ResponseEntity<Result>) getRestTemplate().exchange(BASE_PERSON_URI+"person", HttpMethod.PUT, entity, Result.class);
				final Result result = respEntity.getBody();				
					return result.getMessage();
		};		
	}
	/**
	 * Post endpoint with url http://localhost:8081/person-function/deletePerson
	 * @body {"firstName": "First Name","lastName": "Last Name"}
	 * @return
	 */
	@Bean(name="deletePerson")
	public Function<PersonVO,String> deletePerson(){

		return personVO -> {
			if(null ==personVO || personVO.getFirstName()==null || personVO.getLastName()==null) {
				return "Invalid input";}
			
			HttpEntity<PersonVO> entity = new HttpEntity<PersonVO>(personVO, getHttpHeaders());
			
			ResponseEntity<Result> respEntity = (ResponseEntity<Result>) getRestTemplate().exchange(BASE_PERSON_URI+"person", HttpMethod.DELETE, entity, Result.class);
				final Result result = respEntity.getBody();				
					return result.getMessage();
		};		
	}
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	protected HttpHeaders getHttpHeaders()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);		
		return headers;
	}
}