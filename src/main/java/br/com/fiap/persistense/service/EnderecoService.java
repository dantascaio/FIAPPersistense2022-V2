package br.com.fiap.persistense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Endereco;
import br.com.fiap.persistense.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository EnderecoRepository;

    public List<Endereco> listarEnderecos() {
        return EnderecoRepository.findAll();
    }

    public Optional<Endereco> consultarEndereco(final Integer id) {
        return EnderecoRepository.findById(id);
    }

    public void deletarEndereco(final Integer id) {
        EnderecoRepository.deleteById(id);
    }

    public Endereco salvarEndereco(final Endereco endereco) {
        return EnderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco) {
        return EnderecoRepository.save(endereco);
    }
}
