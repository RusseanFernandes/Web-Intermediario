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

import br.unipe.edu.pos.devweb.model.Produto;
import br.unipe.edu.pos.devweb.repository.ProdutoRepository;

@RestController
@RequestMapping("/api") 
public class ProdutoController {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@PostMapping("/produto") // Inserir
	public Produto salvar(@Valid @RequestBody Produto produto) {
		produto = produtoRepository.save(produto);
		return produto;		
	}
		
	@GetMapping("/produto") // Listar
	public List<Produto> getProduto() {				
		return produtoRepository.findAll();		
	}		
	
	@GetMapping("/produto/{id}") // Listar por Id
	public Produto getProdutoById(@PathVariable Long id) { 
		Produto produto = produtoRepository.findById(id).get();
		return produto;
	}
	
	@PutMapping("/produto") // Atualizar
	public Produto atualizar(@Valid @RequestBody Produto produto) { 
		if(produto.getId()==null)
			throw new NoSuchElementException();
		produto = produtoRepository.save(produto);
		return produto;		
	}	
	
	@DeleteMapping("/produto/{id}") // Deletar
	public String deleteProdutoById(@PathVariable Long id) { 
		produtoRepository.deleteById(id);
		return "Removido Usuário de id: "+id;
	}		
		
}
