package com.example.demo;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

public class ProdutoController {
	
	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping("/produtos")
	public List<Produto> buscarProduto() {
		
		return produtoService.buscarTodos();
	}
	
	@GetMapping("/produtos/quantidade")
	
	public int quantidadeProdutos() {
		
		return produtoService.quantidadeProdutos();
		
	}
	
	@GetMapping("/produtos/{id}")
	public Produto buscarPorId(@PathVariable int id) {
		
		return produtoService.buscarPorId(id);
	}
			
	@PostMapping("/produtos")
	
	public Produto adicionarProduto(@Valid @RequestBody Produto produto) {
			
			return produtoService.adicionarProduto(produto);
			
	}
	
	@DeleteMapping("/produtos/{id}")
	
	public String deletarProduto(@PathVariable int id) {
			
			return produtoService.deletarProduto(id);
		
	}
	
	@PutMapping("/produtos/{id}")
	
	public Produto atualizarProduto(@PathVariable int id, @Valid @RequestBody Produto produtoAtualizado) {
		
				return produtoService.atualizarProduto(id, produtoAtualizado);
	
	}
}




