package br.com.fiap.persistense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public String listarPedidos() {
        return "listaPedidos";
    }

    public String consultarPedido(int id) {
        return "consultaPedido";
    }

    public String deletarPedido(int id) {
        return "deletaPedido";
    }

    public Pedido salvarPedido(final Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public String atualizarPedido() {
        return "atualizaPedido";
    }
}
