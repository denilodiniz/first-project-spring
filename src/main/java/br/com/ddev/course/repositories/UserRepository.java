package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
