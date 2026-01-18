package br.com.olintho.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.olintho.workshopmongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
}
