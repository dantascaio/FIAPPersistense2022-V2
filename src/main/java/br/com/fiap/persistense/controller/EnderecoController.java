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

import br.com.fiap.persistense.model.Endereco;
import br.com.fiap.persistense.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping()
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        return new ResponseEntity<List<Endereco>>(enderecoService.listarEnderecos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> consultarEndereco(@PathVariable("id") final Integer id) {
        return new ResponseEntity<Optional<Endereco>> (enderecoService.consultarEndereco(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletarEndereco(@PathVariable("id") final Integer id) {
        enderecoService.deletarEndereco(id);
        return HttpStatus.OK.name();
    }

    @PostMapping()
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody final Endereco Endereco) {
        return new ResponseEntity<Endereco>(enderecoService.salvarEndereco(Endereco), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody final Endereco Endereco) {
        return new ResponseEntity<Endereco>(enderecoService.atualizarEndereco(Endereco), HttpStatus.OK);
    }
    
}
