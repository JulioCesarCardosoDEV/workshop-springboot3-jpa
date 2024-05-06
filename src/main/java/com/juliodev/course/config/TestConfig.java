package com.juliodev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.juliodev.course.entities.Order;
import com.juliodev.course.entities.User;
import com.juliodev.course.entities.enums.OrderStatus;
import com.juliodev.course.repositories.OrderRepository;
import com.juliodev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Ailton Barros", "ailton@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-03-10T13:21:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-03-11T15:53:42Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-03-16T21:23:37Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	

}
