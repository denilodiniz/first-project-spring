package br.com.ddev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.course.entities.Person;
import br.com.ddev.course.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository reposiroty;
	
	public List<Person> findAll() {
		return reposiroty.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = reposiroty.findById(id);
		return person.get();
	}
	
}
