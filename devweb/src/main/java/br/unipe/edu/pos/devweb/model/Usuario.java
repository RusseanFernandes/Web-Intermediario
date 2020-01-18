package br.unipe.edu.pos.devweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Usuario {

	@Id 
	@GeneratedValue 
	private Long id;
	private String username;
	private String password;
		
	@JsonIgnoreProperties(value ="usuario")
	@OneToMany(mappedBy= "usuario")
	private List<Festa> listaFesta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
