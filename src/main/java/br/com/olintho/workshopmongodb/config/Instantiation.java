package br.com.olintho.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.olintho.workshopmongodb.dto.AuthorDTO;
import br.com.olintho.workshopmongodb.dto.CommentDTO;
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
		
		Post post1 = new Post(null, sdf.parse("10/01/2026"), "Partiu férias", "Estou indo para Cancun. Abraços!", new AuthorDTO(bela));
		Post post2 = new Post(null, sdf.parse("05/04/2026"), "Bom dia", "Acordei ótimamente ótima hoje!", new AuthorDTO(bela));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem maninha!", sdf.parse("10/01/2026"), new AuthorDTO(deda));
		CommentDTO comment2 = new CommentDTO("Aproveita bem as férias!!!", sdf.parse("10/01/2026"), new AuthorDTO(roseli));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia e que DEUS te acompanhe", sdf.parse("05/01/2026"), new AuthorDTO(roseli));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		bela.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(bela);
		
	}

	
}
