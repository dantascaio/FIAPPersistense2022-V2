package br.com.fiap.persistense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.persistense.model.Cliente;

public interface EnderecoRepository extends JpaRepository<Cliente, Integer> {}
