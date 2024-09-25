package com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    @NotBlank(message = "Campo Rua é obrigatório.")
    private String rua;

    @Column
    @NotNull(message = "Campo número é obrigatório.")
    private int numero;

    @Column
    @NotBlank(message = "Campo bairro é obrigatório.")
    private String bairro;

    @Column
    @NotBlank(message = "Campo cidade é obrigatório.")
    private String  cidade;

    @Column
    @NotBlank(message = "Campo estado é obrigatório.")
    private String estado;

    @Column
    @NotBlank(message = "Campo cep é obrigatório.")
    private String cep;
}
