package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;

@Service
public interface PersonService {
	
	public List<Person> getAllPersons();
	
	public Optional<Person> getPerson(Long id);
	
	public Person savePerson(Person person);
	
	public boolean updatePerson(Person person);
	
	public boolean deletePerson(Long id);

}
