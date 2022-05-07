package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Produto;
import br.com.fiap.persistense.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Cacheable(value= "allProdutosCache", unless= "#result.size() == 0")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Cacheable(value= "produtosCache", key= "#id")
    public Optional<Produto> consultarProduto(final Integer id) {
        return produtoRepository.findById(id);
    }

    @Caching(
            evict= {
                    @CacheEvict(value= "produtosCache", key= "#id"),
                    @CacheEvict(value= "allProdutosCache", allEntries= true)
            }
    )
    public void deletarProduto(final Integer id) {
        produtoRepository.deleteById(id);
    }

    @Caching(
            put= { @CachePut(value= "produtosCache", key= "#pedido.codigo") },
            evict= { @CacheEvict(value= "allProdutosCache", allEntries= true) }
    )
    public Produto salvarProduto(final Produto produto) {
        return produtoRepository.save(produto);
    }

    @Caching(
            put= { @CachePut(value= "produtosCache", key= "#pedido.codigo") },
            evict= { @CacheEvict(value= "allProdutosCache", allEntries= true) }
    )
    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
