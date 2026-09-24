package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public int quantidadeProdutos() {
        return (int) produtoRepository.count();
    }

    public Produto buscarPorId(int id) {

        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));
    }

    public Produto adicionarProduto(Produto produto) {

        return produtoRepository.save(produto);
    }

    public String deletarProduto(int id) {

        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNotFoundException("Produto não encontrado");
        }

        produtoRepository.deleteById(id);

        return "Produto removido com sucesso";
    }

    public Produto atualizarProduto(int id, Produto produtoAtualizado) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());

        return produtoRepository.save(produto);
    }
}