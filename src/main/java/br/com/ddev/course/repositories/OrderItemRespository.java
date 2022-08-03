package br.com.ddev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.course.entities.OrderItem;

public interface OrderItemRespository extends JpaRepository<OrderItem, Long>{

}
