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

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return new ResponseEntity<List<Pedido>>(pedidoService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> consultarPedido(@PathVariable("id") final Integer id) {
        return new ResponseEntity<Optional<Pedido>> (pedidoService.consultarPedido(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletarPedido(@PathVariable("id") final Integer id) {
        pedidoService.deletarPedido(id);
        return HttpStatus.OK.name();
    }

    @PostMapping()
    public ResponseEntity<Pedido> salvarPedido(@RequestBody final Pedido pedido) {
        return new ResponseEntity<Pedido>(pedidoService.salvarPedido(pedido), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") final Integer id, @RequestBody final Pedido pedido) {
        return new ResponseEntity<Pedido>(pedidoService.atualizarPedido(pedido), HttpStatus.OK);
    }
}
