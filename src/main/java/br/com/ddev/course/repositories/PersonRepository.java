package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
