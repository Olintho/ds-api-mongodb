package br.com.olintho.workshopmongodb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olintho.workshopmongodb.model.User;


@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = new ArrayList<>();
		User roseli = new User("1", "Roseli", "roseli@rdm.com.br");
		User bela = new User("2", "Bela", "bela@rdm.com.br");
		list.addAll(Arrays.asList(roseli, bela));
		
		return ResponseEntity.ok().body(list);
	}
}
