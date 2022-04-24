package br.com.fiap.persistense.controller;

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

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public String listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/pedidos/{id}")
    public String consultarPedido(@PathVariable("id") int id) {
        return pedidoService.consultarPedido(id);
    }

    @DeleteMapping("/pedidos/{id}")
    public String deletarPedido(@PathVariable("id") int id) {
        return pedidoService.deletarPedido(id);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody final Pedido pedido) {
        return new ResponseEntity<Pedido>(pedidoService.salvarPedido(pedido), HttpStatus.CREATED);
    }

    @PutMapping("/pedidos")
    public String atualizarPedido() {
        return pedidoService.atualizarPedido();
    }
}
