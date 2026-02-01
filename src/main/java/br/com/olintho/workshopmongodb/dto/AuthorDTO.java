package br.com.olintho.workshopmongodb.dto;

import br.com.olintho.workshopmongodb.model.User;

public class AuthorDTO {

	private String id;
	private String name;
	
	public AuthorDTO() {
	}

	public AuthorDTO(User author) {
		this.id = author.getId();
		this.name = author.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
