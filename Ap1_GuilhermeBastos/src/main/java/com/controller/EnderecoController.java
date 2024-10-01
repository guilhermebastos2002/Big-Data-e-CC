package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.model.Endereco;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Endereco")
public class EnderecoController {
    private static List<Endereco> Enderecos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) throws Exception {
        Enderecos.add(endereco);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") int id, @RequestBody Endereco novosDadosEndereco) {
        Endereco enderecoASerAtualizado = null;

        for (Endereco endereco : Enderecos) {
            if (endereco.getId() == id) {
                enderecoASerAtualizado = endereco;
                break;
            }
        }

        if (enderecoASerAtualizado == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        Enderecos.remove(enderecoASerAtualizado);

        enderecoASerAtualizado.setRua(novosDadosEndereco.getRua());
        enderecoASerAtualizado.setNumero(novosDadosEndereco.getNumero());
        enderecoASerAtualizado.setBairro(novosDadosEndereco.getBairro());
        enderecoASerAtualizado.setCidade(novosDadosEndereco.getCidade());
        enderecoASerAtualizado.setEstado(novosDadosEndereco.getEstado());
        enderecoASerAtualizado.setCep(novosDadosEndereco.getCep());

        Enderecos.add(enderecoASerAtualizado);

        return new ResponseEntity<>(HttpStatus.OK);


    }
     @DeleteMapping("{id}")
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable("id") int id) {
        Endereco endereco = null;

        if (endereco.getId() == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        endereco.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
