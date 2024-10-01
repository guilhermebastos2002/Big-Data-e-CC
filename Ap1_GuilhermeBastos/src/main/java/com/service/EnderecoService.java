package com.service;

import com.model.Endereco;
import com.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvarEndereco(Endereco endereco) throws Exception {
        // Validações
        if (enderecoRepository.findByCep(endereco.getCep()).isPresent()) {
            throw new RuntimeException("CEP já está em uso.");
        }

        // Salva o endereço
        return enderecoRepository.save(endereco);
    }
}
