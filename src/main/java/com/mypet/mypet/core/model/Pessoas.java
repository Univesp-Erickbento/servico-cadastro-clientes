package com.mypet.mypet.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoas {
    private long id;
    private String name;
    private String lastName;
    private String genero;
    private String email;
    private String cpf;
    private String rg;
    private String enderecos;
    private String contatos;
    private LocalDate dataDeNasc;
    private Timestamp dataDeCadastro;



}
