package com.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.workshop.entities.Order;
import com.workshop.entities.User;
import com.workshop.entities.enums.OrderStatus;
import com.workshop.repositories.IOrderRepository;
import com.workshop.repositories.IUserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria" , "maria@gmail.com", "99998888" , "password123");
		User user2 = new User(null, "Pedro" , "pedro@gmail.com", "99997777" , "password123");
		User user3 = new User(null, "Joao" , "joao@gmail.com", "99995555" , "password123");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Order o1 = new Order(null, Instant.parse("2023-05-24T19:22:30Z"), OrderStatus.PAID, user3);
		Order o2 = new Order(null, Instant.parse("2023-06-13T10:42:30Z"), OrderStatus.SHIPPED, user2);
		Order o3 = new Order(null, Instant.parse("2023-05-24T21:32:45Z"), OrderStatus.CANCELED, user1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}

}
