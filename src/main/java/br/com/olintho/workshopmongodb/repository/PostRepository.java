package br.com.olintho.workshopmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.olintho.workshopmongodb.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	// Exemplo usando Query Methods com nomes de campo
	List<Post> findByTitleContainingIgnoreCase(String text);

	// Exemplo usando @Query 
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	// Exemplo usando vários operador $and e $or
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} }, { $or: [{ 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } }] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
