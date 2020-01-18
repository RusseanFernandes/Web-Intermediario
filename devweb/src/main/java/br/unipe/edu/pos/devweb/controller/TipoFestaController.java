package br.unipe.edu.pos.devweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.edu.pos.devweb.model.TipoFesta;
import br.unipe.edu.pos.devweb.repository.TipoFestaRepository;

@RestController
@RequestMapping("/api")
public class TipoFestaController {
	
	@Autowired
	private TipoFestaRepository tipoFestaRepository;

	@GetMapping("/TipoFesta")
	public List<TipoFesta> getTipoFesta() {	
		
		return tipoFestaRepository.findAll();		
	}	

	@PostMapping("/TipoFesta") //endpoint para acessar na url
	public TipoFesta salvar(@Valid @RequestBody TipoFesta tipoFesta) { // metodo @valid validação antes de salvar. @requestbody informa que virá um objeto no corpo da requisição.
		tipoFesta = tipoFestaRepository.save(tipoFesta);
		return tipoFesta;		
	}
	
	@GetMapping("/TipoFesta/{id}")
	public TipoFesta getTipoFestaById(@PathVariable Long id) { //busca por ID, pode ser qualquer nome. @PathVariable necessário para fazer a ligação do id inserido na URL
		TipoFesta tipoFesta = tipoFestaRepository.findById(id).get();
		return tipoFesta;
	}
	
	@DeleteMapping("/TipoFesta/{id}")
	public String deleteTipoFestaById(@PathVariable Long id) { //busca por ID, pode ser qualquer nome. @PathVariable necessário para fazer a ligação do id inserido na URL
		tipoFestaRepository.deleteById(id);
		return "Removida Tipo Festa id: "+id;
	}	
	
		
}
