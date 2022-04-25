package br.com.fiap.persistense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.persistense.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
