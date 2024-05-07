package com.juliodev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.juliodev.course.entities.Category;
import com.juliodev.course.entities.Order;
import com.juliodev.course.entities.Product;
import com.juliodev.course.entities.User;
import com.juliodev.course.entities.enums.OrderStatus;
import com.juliodev.course.repositories.CategoryRepository;
import com.juliodev.course.repositories.OrderRepository;
import com.juliodev.course.repositories.ProductRepository;
import com.juliodev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Ailton Barros", "ailton@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-03-10T13:21:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-03-11T15:53:42Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-03-16T21:23:37Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Fantasy book", 90.5, "");
		Product p2 = new Product(null, "Smart Tv", "Modern Tv", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Computer from apple", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Fantasy book", 1200.0, "");
		Product p5 = new Product(null, "Rails for dummies", "Book", 100.99, "");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
	
	

}
