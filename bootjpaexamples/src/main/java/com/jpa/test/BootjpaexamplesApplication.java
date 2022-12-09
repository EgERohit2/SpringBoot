package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.Userrepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexamplesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootjpaexamplesApplication.class, args);
		Userrepository userrepository = context.getBean(Userrepository.class);

		
//		save single user:-
//		User user = new User();
//
//		user.setId(2);
//		user.setName("Rohit");
//		user.setCity("Thane");
//		user.setStatus("successful");
//		
//		user.getId();
//		user.getName();
//
//		user.getCity();
//		user.getStatus();
//
//		User user1 = userrepository.save(user);
//		System.out.println(user1);
//		
//		save multiple user
		
//		User user1 = new User();
//		user1.setId(3);
//		user1.setName("Tejas");
//		user1.setCity("ghatkopar");
//		user1.setStatus("payroll");
//		
//		User user2 = new User();
//		user2.setId(4);
//		user2.setName("ashish");
//		user2.setCity("mulund");
//		user2.setStatus("payroll");
//		
//		List<User>users=List.of(user1,user2);
//		Iterable<User>result=userrepository.saveAll(users);
//		result.forEach(user-> {
//			System.out.println(user);
//		});
		
//		Optional <User>optional =userrepository.findById(2);
//		User user=optional.get();
//		user.setStatus("intern");
//		User result=userrepository.save(user);
//		System.out.println(result);
//		
		Iterable<User> itr = userrepository.findAll();
		itr.forEach(user-> {System.out.println(user);});
	}

}
