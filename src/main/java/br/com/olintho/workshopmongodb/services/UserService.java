package br.com.olintho.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olintho.workshopmongodb.model.User;
import br.com.olintho.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
	
		
		@Autowired
		private UserRepository userRepository;
		
		public List<User> findAll() {
			
			return userRepository.findAll();
	}

}
