package br.unipe.edu.pos.devweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Table(name="tb_contato") opcional, caso não queira nomear a tabela com o nome da class
@Entity // estou dizendo ao banco que existe uma tabela para o banco de dados.
public class Festa {
	
	@Id // O banco que esse campo eh uma chave primaria do banco.
	@GeneratedValue // O próximo campo será gerado automaticamente.
	private Long id;	
	private String nome;	
	private String tema;
	private Float valor;
	//private TipoFesta tipoFesta; Forma de escrever a chave estrangeira.
	
	
	@ManyToOne
	private TipoFesta tipoFesta;
	
	public TipoFesta getTipoFesta() {
		return tipoFesta;
	}
	public void setTipoFesta(TipoFesta tipoFesta) {
		this.tipoFesta = tipoFesta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@JsonIgnoreProperties({"listaFesta"})
	@ManyToOne
	private Usuario usuario;
	
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
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}

		
	// @column Opcional, caso não queira nomear a coluna com o nome diferente do atributo.


}
