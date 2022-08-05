package br.com.ddev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ddev.course.entities.Category;
import br.com.ddev.course.entities.Order;
import br.com.ddev.course.entities.OrderItem;
import br.com.ddev.course.entities.Payment;
import br.com.ddev.course.entities.Product;
import br.com.ddev.course.entities.User;
import br.com.ddev.course.entities.enums.OrderStatus;
import br.com.ddev.course.repositories.CategoryRepository;
import br.com.ddev.course.repositories.OrderItemRespository;
import br.com.ddev.course.repositories.OrderRepository;
import br.com.ddev.course.repositories.ProductRepository;
import br.com.ddev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRespository orderItemRespository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User user2 = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1); 
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2); 
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
		
		Category category1 = new Category(null, "Electronics"); 
		Category category2 = new Category(null, "Books"); 
		Category category3 = new Category(null, "Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		//Salvando os produtos novamente para associar as categorias
		
		product1.getCategories().add(category2);
		product2.getCategories().addAll(Arrays.asList(category1, category3));
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice()); 
		OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice()); 
		OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice()); 
		OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice()); 
		
		orderItemRespository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
		Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(payment1);
		
		orderRepository.save(order1);
	
	}
	
}
