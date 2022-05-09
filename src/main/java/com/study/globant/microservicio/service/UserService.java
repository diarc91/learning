package com.study.globant.microservicio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.globant.microservicio.model.User;

@Service
public class UserService {
	
	private static List<User> users; 
	
	public List<User> getAll(){
		
		User user1 = new User();
		user1.setFirstName("Diego Fernando");
		user1.setLastName("Arenas Ceballos");
		user1.setId(1053812339);
		user1.setBirthDate(LocalDate.now());
		return Arrays.asList(user1);
	}

	public void save(User user) throws Exception {
		
		long existentes = this.users.stream()
			.filter(predicate -> predicate.getId() == user.getId())
			.count();
		
		if(existentes > 0) {
			this.users.add(user);
		}else {
			throw new Exception();
		}
		
	}
	
}
