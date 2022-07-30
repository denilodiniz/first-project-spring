package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
