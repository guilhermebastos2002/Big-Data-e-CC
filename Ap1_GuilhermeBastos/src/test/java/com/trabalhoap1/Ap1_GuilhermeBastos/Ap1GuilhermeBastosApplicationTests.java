package com.trabalhoap1.Ap1_GuilhermeBastos;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Cliente;
import com.service.ClienteService;

@SpringBootTest
class Ap1GuilhermeBastosApplicationTests {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void should_not_create_client_if_cpf_has_more_than_nine_characters() {
        Cliente clienteInvalido = new Cliente();
        clienteInvalido.setNome("Cliente Teste");
        clienteInvalido.setEmail("cliente@teste.com");
        clienteInvalido.setCpf("12345678901"); 
        clienteInvalido.setDataNascimento(LocalDate.now()); 
        clienteInvalido.setTelefone("123456789");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            clienteService.salvarCliente(clienteInvalido); 
        });

        // Verifique a mensagem da exceção
        String expectedMessage = "O CPF deve ter no máximo 11 caracteres.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage), "A mensagem de erro não está correta."); 
    }
}
