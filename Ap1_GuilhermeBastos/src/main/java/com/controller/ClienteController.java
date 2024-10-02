package com.controller;

import com.model.Cliente;
import com.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private static List<Cliente> Clientes = new ArrayList<>();

    @GetMapping("{id}")
public ResponseEntity<Cliente> getClienteById(@PathVariable("id") int id) {
    Optional<Cliente> cliente = clienteService.findById(id);  // Usar o serviço para buscar do banco
    if (cliente.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
}


@PostMapping
public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid Cliente cliente) {
    Cliente novoCliente = clienteService.salvar(cliente);

    System.out.println("Cliente salvo: " + novoCliente);

    return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);   
}


    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") int id, @RequestBody Cliente novosDadosCliente) {
        Cliente clienteASerAtualizado = null;

        for (Cliente cliente : Clientes) {
            if (cliente.getId() == id) {
                clienteASerAtualizado = cliente;
                break;
            }
        }

        if (clienteASerAtualizado == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Clientes.remove(clienteASerAtualizado);

        clienteASerAtualizado.setNome(novosDadosCliente.getNome());
        clienteASerAtualizado.setEmail(novosDadosCliente.getEmail());
        clienteASerAtualizado.setCpf(novosDadosCliente.getCpf());
        clienteASerAtualizado.setDataNascimento(novosDadosCliente.getDataNascimento());
        clienteASerAtualizado.setTelefone(novosDadosCliente.getTelefone());

        Clientes.add(clienteASerAtualizado);

        return new ResponseEntity<>(clienteASerAtualizado, HttpStatus.OK);
    }
}
