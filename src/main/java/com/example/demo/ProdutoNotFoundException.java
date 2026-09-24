package com.example.demo;

public class ProdutoNotFoundException extends RuntimeException {

	public ProdutoNotFoundException(String mensagem) {
		super(mensagem);
	}
}

