package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Cliente;
import br.com.fiap.persistense.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> consultarCliente(final Integer id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(final Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente salvarCliente(final Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
