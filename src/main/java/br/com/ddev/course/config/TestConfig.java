package br.com.ddev.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ddev.course.entities.Person;
import br.com.ddev.course.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		Person person1 = new Person(1L, "Maria", "maria@gmail.com", "+5583998781617", "maria123");
		Person person2 = new Person(2L, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Person person3 = new Person(3L, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		personRepository.saveAll(Arrays.asList(person1, person2, person3));
		
	}
	
}
