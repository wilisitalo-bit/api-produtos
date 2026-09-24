package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "produtos")
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ficar vazio")
	private String nome;
	
	@Positive(message = "Preço deve ser maior que zero")
	private double preco;
	
	public Produto() {
		
	}
	
	public Produto(Integer id, String nome, double preco) {
		
		this.id =id;
		this.nome = nome;
		this.preco = preco;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
	    this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		
		this.preco = preco;
		
	}
}
