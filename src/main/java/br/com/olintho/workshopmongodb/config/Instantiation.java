package br.com.olintho.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.olintho.workshopmongodb.model.User;
import br.com.olintho.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User roseli = new User(null, "Roseli", "roseli@rdm.com.br", "(11) 9 8765-4321", "First Street");
		User bela = new User(null, "Bela", "bela@rdm.com.br", "(11) 9 8765-4322", "Second Street");
		User deda = new User(null, "Deda", "deda@rdm.com.br", "(11) 9 8765-4323", "Third Street");
		User le = new User(null, "Leticia", "le@rdm.com.br", "(11) 9 8765-4324", "Fourth Street");
		
		userRepository.saveAll(Arrays.asList(roseli, deda, bela, le));
	}

	
}
