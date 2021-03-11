package com.caique.locadora.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nomeCompleto")
	private String nome;

	@Column(name = "telefone")
	private int telefone;

	@Column(name = "cpf")
	private int cpf;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "dataRetirada")
	private Date dtretirada;

	@Column(name = "dataDevolucao")
	private Date dtdevolucao;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CLIENTE_FILME", 
	joinColumns = @JoinColumn(name = "ID_CLIENTES"), 
	inverseJoinColumns = @JoinColumn(name = "ID_FILME"))

	private Set<Filme> filme;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nome, int telefone, int cpf, String endereco, Date dtretirada, Date dtdevolucao,
			Set<Filme> filme) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dtretirada = dtretirada;
		this.dtdevolucao = dtdevolucao;
		this.filme = filme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDtretirada() {
		return dtretirada;
	}

	public void setDtretirada(Date dtretirada) {
		this.dtretirada = dtretirada;
	}

	public Date getDtdevolucao() {
		return dtdevolucao;
	}

	public void setDtdevolucao(Date dtdevolucao) {
		this.dtdevolucao = dtdevolucao;
	}

	public Set<Filme> getFilme() {
		return filme;
	}

	public void setFilme(Set<Filme> filme) {
		this.filme = filme;
	}

}
