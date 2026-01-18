package br.com.olintho.workshopmongodb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olintho.workshopmongodb.model.User;
import br.com.olintho.workshopmongodb.services.UserService;

//HEREIN : OSJ - Capitulo 347

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> allUsers = userService.findAll();
		return ResponseEntity.ok().body(allUsers);
	}
}
