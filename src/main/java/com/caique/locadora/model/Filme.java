package com.caique.locadora.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Filme {
	@Id
	private int id;
	private String titulo;
	private Date anoLancamento;
	private String director;
	private String descricao;
	private String duracao;
	private String capa;
	
    @ManyToMany(mappedBy = "filme", fetch = FetchType.LAZY)
    private Set<Cliente> usuarios;
	
	public Filme() {
	}
	
	public Filme(int id, String titulo, Date anoLancamento, String director, String descricao, String duracao,
			String capa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.director = director;
		this.descricao = descricao;
		this.duracao = duracao;
		this.capa = capa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
	
	
}
