package com.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @Column
    @NotBlank(message = "Campo E-mail é obrigatório.")
    private String email;

    @Column
    @NotBlank(message = "Campo CPF é obrigatório.")
    private String cpf;

    @Column
    @NotNull(message = "Campo Data de Nascimento é obrigatório.")
    private LocalDateTime dataNascimento;

    @Column
    private String telefone;

}
