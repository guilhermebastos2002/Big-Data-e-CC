package com.repository;

import com.model.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Métodos de busca por email e cpf
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByCpf(String cpf);
}
