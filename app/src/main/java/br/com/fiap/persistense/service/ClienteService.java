package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Cliente;
import br.com.fiap.persistense.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Cacheable(value= "allClientesCache", unless= "#result.size() == 0")
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


    @Cacheable(value= "clienteCache", key= "#id")
    public Optional<Cliente> consultarCliente(final Integer id) {
        return clienteRepository.findById(id);
    }

    @Caching(
            evict= {
                    @CacheEvict(value= "clienteCache", key= "#id"),
                    @CacheEvict(value= "allClientesCache", allEntries= true)
            }
    )
    public void deletarCliente(final Integer id) {
        clienteRepository.deleteById(id);
    }

    @Caching(
            put= { @CachePut(value= "clienteCache", key= "#cliente.codigo") },
            evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
    )
    public Cliente salvarCliente(final Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Caching(
            put= { @CachePut(value= "clienteCache", key= "#cliente.codigo") },
            evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
    )
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
