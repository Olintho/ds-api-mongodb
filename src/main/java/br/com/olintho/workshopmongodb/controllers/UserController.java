package br.com.olintho.workshopmongodb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olintho.workshopmongodb.dto.UserDTO;
import br.com.olintho.workshopmongodb.model.User;
import br.com.olintho.workshopmongodb.services.UserService;

//HEREIN : OSJ - Capitulo 347

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> allUsers = userService.findAll();
		List<UserDTO> allUsersDto = allUsers.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(allUsersDto);
	}
}
