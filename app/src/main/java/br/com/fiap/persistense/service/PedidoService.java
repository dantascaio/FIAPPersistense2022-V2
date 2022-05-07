package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Cacheable(value= "allPedidosCache", unless= "#result.size() == 0")
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Cacheable(value= "pedidoCache", key= "#id")
    public Optional<Pedido> consultarPedido(final Integer id) {
        return pedidoRepository.findById(id);
    }

    @Caching(
            evict= {
                    @CacheEvict(value= "pedidoCache", key= "#id"),
                    @CacheEvict(value= "allPedidosCache", allEntries= true)
            }
    )
    public void deletarPedido(final Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Caching(
            put= { @CachePut(value= "pedidoCache", key= "#pedido.codigo") },
            evict= { @CacheEvict(value= "allPedidosCache", allEntries= true) }
    )
    public Pedido salvarPedido(final Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Caching(
            put= { @CachePut(value= "pedidoCache", key= "#pedido.codigo") },
            evict= { @CacheEvict(value= "allPedidosCache", allEntries= true) }
    )
    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
