package br.com.ddev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.course.entities.User;
import br.com.ddev.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository reposiroty;
	
	public List<User> findAll() {
		return reposiroty.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> person = reposiroty.findById(id);
		return person.get();
	}
	
}
