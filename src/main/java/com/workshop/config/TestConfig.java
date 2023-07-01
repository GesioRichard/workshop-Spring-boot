package com.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.workshop.entities.Category;
import com.workshop.entities.Order;
import com.workshop.entities.OrderItem;
import com.workshop.entities.Product;
import com.workshop.entities.User;
import com.workshop.entities.enums.OrderStatus;
import com.workshop.repositories.ICategoryRepository;
import com.workshop.repositories.IOrderItemRepository;
import com.workshop.repositories.IOrderRepository;
import com.workshop.repositories.IProductRepository;
import com.workshop.repositories.IUserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "UrlExample");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "UrlExample");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "UrlExample");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "UrlExample");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "UrlExample"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User user1 = new User(null, "Maria" , "maria@gmail.com", "99998888" , "password123");
		User user2 = new User(null, "Pedro" , "pedro@gmail.com", "99997777" , "password123");
		User user3 = new User(null, "Joao" , "joao@gmail.com", "99995555" , "password123");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Order o1 = new Order(null, Instant.parse("2023-05-24T19:22:30Z"), OrderStatus.PAID, user3);
		Order o2 = new Order(null, Instant.parse("2023-06-13T10:42:30Z"), OrderStatus.SHIPPED, user2);
		Order o3 = new Order(null, Instant.parse("2023-05-24T21:32:45Z"), OrderStatus.CANCELED, user1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2);
		OrderItem oi2 = new OrderItem(o1, p3, 1);
		OrderItem oi3 = new OrderItem(o2, p3, 2);
		OrderItem oi4 = new OrderItem(o3, p5, 2); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}

}
