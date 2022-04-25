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

import br.com.fiap.persistense.model.Cliente;
import br.com.fiap.persistense.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> consultarCliente(@PathVariable("id") final Integer id) {
        return new ResponseEntity<Optional<Cliente>> (clienteService.consultarCliente(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable("id") final Integer id) {
        clienteService.deletarCliente(id);
        return HttpStatus.OK.name();
    }

    @PostMapping()
    public ResponseEntity<Cliente> salvarCliente(@RequestBody final Cliente Cliente) {
        return new ResponseEntity<Cliente>(clienteService.salvarCliente(Cliente), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody final Cliente Cliente) {
        return new ResponseEntity<Cliente>(clienteService.atualizarCliente(Cliente), HttpStatus.OK);
    }
    
}
