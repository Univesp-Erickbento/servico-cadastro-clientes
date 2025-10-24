package com.mypet.mypet.application.core.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String nome;

    private String sobrenome;

    @Pattern(regexp = "\\d{11}")
    private String cpf;

    private String rg;
    private String genero;
    private String perfis;
    private String email;
    private String contato;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private LocalDate dataCadastro = LocalDate.now();

    @Column(name = "pessoa_id", nullable = false)
    private Long pessoaId;

    private String clienteReg;

    @Column(nullable = false)
    private Boolean ativo = true;
}
