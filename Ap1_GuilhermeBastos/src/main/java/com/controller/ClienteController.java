package com.controller;

import com.model.Cliente;
import org.springframework.web.bind.annotation.RestController;
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

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    private static List<Cliente> Clientes = new ArrayList<>();

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") int id) {
        Cliente response = null;

        for (Cliente cliente : Clientes) {
            if (cliente.getId() == id) {
                response = cliente;
                break;
            }
        }

        if (response == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) throws Exception {
        Clientes.add(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);   

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
