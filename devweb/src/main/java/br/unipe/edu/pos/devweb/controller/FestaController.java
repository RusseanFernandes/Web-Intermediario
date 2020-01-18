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

import br.unipe.edu.pos.devweb.model.Festa;
import br.unipe.edu.pos.devweb.repository.FestaRepository;

@RestController
@RequestMapping("/api") // raiz
public class FestaController {

	@Autowired // Usa a inversão de controle, o spring cria o objeto e insere, sem a necessidade do new.
	private FestaRepository festaRepository;
	
	@GetMapping("/festa")// quero que esse cara seja acessível
	public List<Festa> getFesta() {	
			
		return festaRepository.findAll();		
	}	
	
	@GetMapping("/festa/nome/{nome}")// quero que esse cara seja acessível
	public List<Festa> getFestaByNome(@PathVariable String nome) {			
		return festaRepository.findFestaByNome(nome);		
	}	
	
	@GetMapping("/festa/valor/between/{valorA}/{valorB}")// Consulta por intervalo de valor
	public List<Festa> getFestaByValorBetween(@PathVariable Float valorA,@PathVariable Float valorB) {			
		return festaRepository.findFestaByValorBetween(valorA, valorB);		
	}		
	
	@PostMapping("/festa") //endpoint para acessar na url
	public Festa salvar(@Valid @RequestBody Festa festa) { // metodo @valid validação antes de salvar. @requestbody informa que virá um objeto no corpo da requisição.
		festa = festaRepository.save(festa);
		return festa;		
	}
	
	@PutMapping("/festa") //endpoint para acessar na url
	public Festa atualizar(@Valid @RequestBody Festa festa) { // metodo @valid validação antes de salvar. @requestbody informa que virá um objeto no corpo da requisição.
		if(festa.getId()==null)
			throw new NoSuchElementException();
		festa = festaRepository.save(festa);
		return festa;		
	}	
	
	@GetMapping("/festa/{id}")
	public Festa getFestaById(@PathVariable Long id) { //busca por ID, pode ser qualquer nome. @PathVariable necessário para fazer a ligação do id inserido na URL
		Festa festa = festaRepository.findById(id).get();
		return festa;
	}
	
	@DeleteMapping("/festa/{id}")
	public String deleteFestaById(@PathVariable Long id) { //busca por ID, pode ser qualquer nome. @PathVariable necessário para fazer a ligação do id inserido na URL
		festaRepository.deleteById(id);
		return "Removida Festa id: "+id;
	}

		
}
