package com.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import lombok.Data;
import java.util.List;


@Data
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    @NotBlank(message = "Campo nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Campo E-mail é obrigatório.")
    @Email(message = "Digite um email válido.")
    private String email;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Campo CPF é obrigatório.")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    @Column
    @NotNull(message = "Campo Data de Nascimento é obrigatório.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column
    @Pattern(regexp = "\\d{5}\\-\\d{4}", message = "O CEP deve estar no formato XXXXX-XXX")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    public void associarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

     public boolean isMaiorDeIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
     }

}
