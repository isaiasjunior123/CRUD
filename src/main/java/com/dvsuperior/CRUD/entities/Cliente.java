package com.dvsuperior.CRUD.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private Double renda;
	private LocalDate dataNascimento;
	private Integer quantidadeFilhos;

	public Cliente() {

	}

	public Cliente(Long id, String nome, String cpf, Double renda, LocalDate dataNascimento, Integer quantidadeFilhos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
		this.dataNascimento = dataNascimento;
		this.quantidadeFilhos = quantidadeFilhos;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getQuantidadeFilhos() {
		return quantidadeFilhos;
	}

	public void setQuantidadeFilhos(Integer quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	};

}
