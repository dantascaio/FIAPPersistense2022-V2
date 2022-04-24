package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> consultarPedido(final Integer id) {
        return pedidoRepository.findById(id);
    }

    public void deletarPedido(final Integer id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido salvarPedido(final Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
