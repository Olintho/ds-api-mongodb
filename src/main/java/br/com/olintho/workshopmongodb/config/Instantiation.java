package br.com.olintho.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.olintho.workshopmongodb.dto.AuthorDTO;
import br.com.olintho.workshopmongodb.model.Post;
import br.com.olintho.workshopmongodb.model.User;
import br.com.olintho.workshopmongodb.repository.PostRepository;
import br.com.olintho.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User roseli = new User(null, "Roseli", "roseli@rdm.com.br");
		User bela = new User(null, "Bela", "bela@rdm.com.br");
		User deda = new User(null, "Deda", "deda@rdm.com.br");
		User le = new User(null, "Leticia", "le@rdm.com.br");

		userRepository.saveAll(Arrays.asList(roseli, deda, bela, le));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(bela));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(bela));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		bela.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(bela);
		
	}

	
}
