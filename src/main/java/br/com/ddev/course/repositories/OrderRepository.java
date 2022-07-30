package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
