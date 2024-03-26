package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.model.CustomResponse;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping
	public CustomResponse<Person> getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		
		if (persons.isEmpty()) {
			return new CustomResponse<Person>(false, "No se encontró ningun registro", persons);
		} else {
			return new CustomResponse<Person>(true, "Se encontró información", persons);
		}
	}
	
	
	@GetMapping("/{id}")
	public CustomResponse<Person> getPerson(@PathVariable Long id) {
		Optional<Person> person = personService.getPerson(id);
		
		if (person.isPresent()) {
			return new CustomResponse<>(true, "Persona encontrada", List.of(person.get()));
		} else {
			return new CustomResponse<>(false, "Sin resultados", List.of());
		}
		
	}
	
	@PostMapping
	public CustomResponse<Person> savePerson(@RequestBody Person person) {
		
		Person newPerson = personService.savePerson(person);
		
		return new CustomResponse<>(true, "Registro creado", List.of(newPerson));
	}
	
	
	
	@PutMapping
	public CustomResponse<Person> updatePerson(@RequestBody Person personRequest) {
		
		boolean isUserUpdated = personService.updatePerson(personRequest); 
		
		if (isUserUpdated) {
			return new CustomResponse<>(true, "Registro actualizado", null);
		} else {
			return new CustomResponse<>(false, "No se encontró el usuario a actualizar", null);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public CustomResponse<Person> deletePerson(@PathVariable Long id) {
		
		boolean isUserDeleted = personService.deletePerson(id);
		
		if(isUserDeleted) {
			return new CustomResponse<>(true, "Registro eliminado", null);
		} else {
			return new CustomResponse<>(false, "No se encontró el usuario a eliminar", null);
		}
		
		
	}
	
	

}
