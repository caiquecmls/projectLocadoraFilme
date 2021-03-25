package com.caique.locadora.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "anoLancamento")
	private String anoLancamento;

	@Column(name = "diretor")
	private String director;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "duracaoFilme")
	private String duracao;

	@Column(name = "capaImg")
	private String capa;

	@ManyToMany(mappedBy = "filme", fetch = FetchType.LAZY)
	private Set<Cliente> clientes;

	public Filme() {
	}

	public Filme(int id, String titulo, String anoLancamento, String director, String descricao, String duracao,
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

	private static List<Filme> filmeNomes = new ArrayList<>();

	public void addFilme(Filme filme) {
		filmeNomes.add(filme);
	}

	public static List<Filme> getFilmeNomes() {
		return filmeNomes;
	}

	public static void setFilmeNomes(List<Filme> filmeNomes) {
		Filme.filmeNomes = filmeNomes;
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

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
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
