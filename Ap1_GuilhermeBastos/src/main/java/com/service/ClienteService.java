package com.service;

import com.model.Cliente;
import com.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente) throws Exception {
        // Validações
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Email já está em uso.");
        }

        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já está em uso.");
        }

        if (!cliente.isMaiorDeIdade()) {
            throw new Exception("O cliente deve ter pelo menos 18 anos.");
        }

        return clienteRepository.save(cliente);
    }
}
