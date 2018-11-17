package com.milan.cloud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.milan.api.exception.BusinessException;
import com.milan.cloud.function.vo.PersonVO;
import com.milan.cloud.function.vo.Result;
import com.milan.entities.Person;
import com.milan.repository.PersonRepository;
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findByLastName(String lastName) throws BusinessException
	{
		List<Person> personList = personRepository.findAll();
		List<Person> result = personList.parallelStream().filter((Person p)->p.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
		if(null==result||result.size()==0) {
			throw new BusinessException("Person with lastName "+lastName+" not found.");
		}
		return result;
	}
	
	public List<PersonVO> findAllPerson()
	{
		List<Person> personList = personRepository.findAll();
		List<PersonVO> resultList = personList.parallelStream().map((Person p)->{PersonVO person = new PersonVO();
		person.setFirstName(p.getFirstName());
		person.setLastName(p.getLastName());
		return person;}).collect(Collectors.toList());
		return resultList;
	}
	
	public Result createPerson(@RequestBody PersonVO personVO)
	{
		Result result = new Result();
		Person person = new Person();
		person.setFirstName(personVO.getFirstName());
		person.setLastName(personVO.getLastName());
		Person resultPerson = personRepository.save(person);
		if(null==resultPerson)
		{
			result.setCode(500);
			result.setMessage("Failure");
		}
		else{
			result.setCode(200);
			result.setMessage("Success");
		}
		return result;
	}
	
	public Result deletePerson(PersonVO personVO) throws BusinessException
	{
		Result result = new Result();
		Person person = new Person();
		person.setFirstName(personVO.getFirstName());
		person.setLastName(personVO.getLastName());
		List<Person> personList = findByLastName(personVO.getLastName());
		/*p.parallelStream().filter(
				(Person v)->{if(v.getFirstName().equals(personVO.getFirstName())){personRepository.delete(v);}}).close();*/
		for(Person p:personList)
		{
			if(p.getFirstName().equals(personVO.getFirstName()))
			{
				personRepository.delete(p);
				result.setCode(200);
				result.setMessage("Success");
				break;
			}
		}
		
		if(result.getCode()!=200)
		{
			result.setCode(500);
			result.setMessage("Failure");
		}		
		return result;
	}
	
	
	public Result updatePerson(PersonVO personVO) throws BusinessException
	{
		Result result = new Result();
		Person person = new Person();
		person.setFirstName(personVO.getFirstName());
		person.setLastName(personVO.getLastName());
		List<Person> personList = findByLastName(personVO.getLastName());
		/*p.parallelStream().filter(
				(Person v)->{if(v.getFirstName().equals(personVO.getFirstName())){personRepository.delete(v);}}).close();*/		
		for(Person p:personList)
		{
			if(!p.getFirstName().equals(personVO.getFirstName()))
			{
				personRepository.save(person);
				result.setCode(200);
				result.setMessage("Success");
				break;
			}
		}
		
		if(result.getCode()!=200)
		{
			result.setCode(500);
			result.setMessage("Failure");
		}		
		return result;
	}
}
