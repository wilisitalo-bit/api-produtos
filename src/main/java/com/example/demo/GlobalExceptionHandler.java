package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> tratarErroValidacao(MethodArgumentNotValidException ex) {
		
		Map<String, String> erros = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(erro -> {
			erros.put(erro.getField(), erro.getDefaultMessage());
			
		});
		
		return erros;
		
	}
	
	@ExceptionHandler(ProdutoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> tratarProdutoNaoEncontrado(ProdutoNotFoundException ex) {

	    Map<String, String> erro = new HashMap<>();

	    erro.put("erro", ex.getMessage());

	    return erro;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> tratarErroArgumento(IllegalArgumentException ex) {

	    Map<String, String> erro = new HashMap<>();

	    erro.put("erro", ex.getMessage());

	    return erro;
	}
}

