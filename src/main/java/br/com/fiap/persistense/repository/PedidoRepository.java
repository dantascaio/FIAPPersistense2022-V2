package br.com.fiap.persistense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.model.PedidoPK;

public interface PedidoRepository extends JpaRepository<Pedido, PedidoPK> {}
