package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> getPerson(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);

	}

	@Override
	public boolean deletePerson(Long id) {
		
		Optional<Person> personFound = personRepository.findById(id);
		
		if (personFound.isPresent()) {
			personRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
		
		

	}

	@Override
	public boolean updatePerson(Person person) {
		
		Optional<Person> personFound = personRepository.findById(person.getId());
		
		if (personFound.isPresent()) {
			personFound.get().setNombre(person.getNombre());
			personFound.get().setApellido(person.getApellido());
			personFound.get().setFechaNacimiento(person.getFechaNacimiento());
			personFound.get().setPuesto(person.getPuesto());
			personFound.get().setSueldo(person.getSueldo());
	            
			personRepository.save(personFound.get());
			
			return true;
		} else {
			return false;
		}

	}

}
