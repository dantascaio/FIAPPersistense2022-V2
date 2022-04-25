package br.com.fiap.persistense.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.persistense.model.Produto;
import br.com.fiap.persistense.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<Produto>> listarProdutos() {
        return new ResponseEntity<List<Produto>>(produtoService.listarProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> consultarProduto(@PathVariable("id") final Integer id) {
        return new ResponseEntity<Optional<Produto>> (produtoService.consultarProduto(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable("id") final Integer id) {
        produtoService.deletarProduto(id);
        return HttpStatus.OK.name();
    }

    @PostMapping()
    public ResponseEntity<Produto> salvarProduto(@RequestBody final Produto produto) {
        return new ResponseEntity<Produto>(produtoService.salvarProduto(produto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") final Integer id, @RequestBody final Produto produto) {
        return new ResponseEntity<Produto>(produtoService.atualizarProduto(produto), HttpStatus.OK);
    }
    
}
