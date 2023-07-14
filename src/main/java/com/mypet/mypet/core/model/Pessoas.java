package com.mypet.mypet.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoas {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String cpf;
    private String rg;
    private int age;
    private String enderecos;
    private String contatos;
    private LocalDate dataDeNasc;
}
