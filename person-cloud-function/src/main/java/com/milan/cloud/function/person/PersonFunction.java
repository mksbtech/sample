package com.milan.cloud.function.person;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.annotation.RequestScope;

import com.milan.api.exception.BusinessException;
import com.milan.cloud.function.vo.PersonVO;
import com.milan.cloud.function.vo.Result;
import com.milan.cloud.service.PersonService;
import com.milan.entities.Person;

@SpringBootApplication
@Configuration
@ComponentScan(value = { "com.milan.cloud" })
@EntityScan(basePackages = "com.milan.entities")
@EnableAutoConfiguration
@EnableJpaRepositories("com.milan.repository")
public class PersonFunction {
	
	@Autowired
	private PersonService personService;
	
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
		
		return (v)->{
			return personService.findAllPerson();
		};
	}
	
	/**
	 * Post endpoint with url /person-function/personByLastName
	 * Content Type of the request should be text/plain
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@Bean(name="personByLastName")
	@RequestScope
	public Function<String, List<Person>> getPersonWithLastName() throws IOException{		
		
		return (v)->{
			List<Person> personList=null;;
			try {
				personList = personService.findByLastName(v);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return personList;
			}
			return personList;
			
		};
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
			
			Result result = personService.createPerson(personVO);
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
			
			Result result=null;
			try {
				result = personService.updatePerson(personVO);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failure";
			}
			return result.getMessage();
		};		
	}
	/**
	 * Post endpoint with url http://localhost:8081/person-function/deletePerson
	 * @body {"firstName": "First Name","lastName": "Last Name"}
	 * @return
	 */
	@Bean(name="deletePerson")
	public Function<PersonVO,String> deletePerson() throws BusinessException{

		return personVO -> {
			if(null ==personVO || personVO.getFirstName()==null || personVO.getLastName()==null) {
				return "Invalid input";}
			
			Result result=null;
			try {
				result = personService.deletePerson(personVO);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failure";
			}
			return result.getMessage();
			
		};		
	}	
}