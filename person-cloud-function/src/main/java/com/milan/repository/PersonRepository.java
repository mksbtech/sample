package com.milan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milan.entities.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public List<Person> findByLastName(String lastName);
	public List<Person> findAll();
	@SuppressWarnings("unchecked")
	public Person save(Person person);
	public void delete(Person person);

}
