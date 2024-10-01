//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;

//public class ClienteServiceTest {

   // @Autowired
    //private ClienteService clienteService; // Supondo que você tenha um serviço chamado ClienteService

    // @Test
    // public void should_not_create_client_if_cpf_has_more_than_nine_characters() {
    
    //    Cliente clienteInvalido = new Cliente();
    //    clienteInvalido.setNome("Cliente Teste");
    //    clienteInvalido.setEmail("cliente@teste.com");
    //    clienteInvalido.setCpf("12345678901"); // CPF com 11 caracteres, o que é inválido
    //   clienteInvalido.setDataNascimento(LocalDateTime.now()); // Data de nascimento válida
    //    clienteInvalido.setTelefone("123456789");

    //    Exception exception = Assertions.assertThrows(Exception.class, () -> {
    //        clienteService.createCliente(clienteInvalido); // Espera uma exceção ao tentar criar o cliente
    //   });

        // Verifique a mensagem da exceção
    //    String expectedMessage = "O CPF deve ter no máximo 9 caracteres.";
    //    String actualMessage = exception.getMessage();

    //    Assertions.assertTrue(actualMessage.contains(expectedMessage), "A mensagem de erro não está correta."); // Verifica se a mensagem está correta
    //}
//}
