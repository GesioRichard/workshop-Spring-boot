package com.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.workshop.entities.User;
import com.workshop.repositories.IUserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria" , "maria@gmail.com", "99998888" , "password123");
		User user2 = new User(null, "Pedro" , "pedro@gmail.com", "99997777" , "password123");
		User user3 = new User(null, "Joao" , "joao@gmail.com", "99995555" , "password123");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
	}

}
