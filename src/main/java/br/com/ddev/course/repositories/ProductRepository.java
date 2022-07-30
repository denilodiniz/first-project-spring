package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
