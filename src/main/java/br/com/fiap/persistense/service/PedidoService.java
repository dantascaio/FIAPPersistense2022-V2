package br.com.fiap.persistense.service;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    public String listarPedidos() {
        return "listaPedidos";
    }

    public String consultarPedido(int id) {
        return "consultaPedido";
    }

    public String deletarPedido(int id) {
        return "deletaPedido";
    }

    public String salvarPedido() {
        return "salvarPedido";
    }

    public String atualizarPedido() {
        return "atualizaPedido";
    }
}
