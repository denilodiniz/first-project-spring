package br.com.ddev.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.course.entities.Person;
import br.com.ddev.course.services.PersonService;

@RestController
@RequestMapping(value = "/users")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person person = service.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
}
