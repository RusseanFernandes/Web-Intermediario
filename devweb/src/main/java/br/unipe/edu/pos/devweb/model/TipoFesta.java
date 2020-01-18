package br.unipe.edu.pos.devweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // esta classe pertence a uma tabela do banco
public class TipoFesta {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nome", length=100)
	private String nome; //100 caracteres
	@Column(name="descricao", length=255)
	private String descricao; //255 caracteres
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
