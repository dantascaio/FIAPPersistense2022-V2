package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Produto;
import br.com.fiap.persistense.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> consultarProduto(final Integer id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(final Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto salvarProduto(final Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
