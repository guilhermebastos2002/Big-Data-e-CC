package com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "Campo Rua é obrigatório.")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caracteres.")
    private String rua;

    @Column
    @NotNull(message = "Campo número é obrigatório.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O número do endereço deve ser alfanumérico.")
    private String numero;

    @Column
    @NotBlank(message = "Campo bairro é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String bairro;

    @Column
    @NotBlank(message = "Campo cidade é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String  cidade;

    public enum Estado {
        AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;
    }

    @Column
    @NotBlank(message = "Campo estado é obrigatório.")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    @NotBlank(message = "Campo cep é obrigatório.")
    @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
}
