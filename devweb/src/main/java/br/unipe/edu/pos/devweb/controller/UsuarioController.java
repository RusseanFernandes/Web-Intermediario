package br.unipe.edu.pos.devweb.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.edu.pos.devweb.model.Usuario;
import br.unipe.edu.pos.devweb.repository.UsuarioRepository;

@RestController
@RequestMapping("/api") 
public class UsuarioController {


	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario") // Inserir
	public Usuario salvar(@Valid @RequestBody Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;		
	}
		
	@GetMapping("/usuario") // Listar
	public List<Usuario> getUsuario() {				
		return usuarioRepository.findAll();		
	}		
	
	@GetMapping("/usuario/{id}") // Listar por Id
	public Usuario getUsuarioById(@PathVariable Long id) { 
		Usuario usuario = usuarioRepository.findById(id).get();
		return usuario;
	}
	
	@PutMapping("/usuario") // Atualizar
	public Usuario atualizar(@Valid @RequestBody Usuario usuario) { 
		if(usuario.getId()==null)
			throw new NoSuchElementException();
		usuario = usuarioRepository.save(usuario);
		return usuario;		
	}	
	
	@DeleteMapping("/usuario/{id}") // Deletar
	public String deleteUsuarioById(@PathVariable Long id) { 
		usuarioRepository.deleteById(id);
		return "Removido Usuário de id: "+id;
	}	
		
}

