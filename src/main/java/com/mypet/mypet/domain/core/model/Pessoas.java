package com.mypet.mypet.domain.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.mypet.mypet.domain.enums.Generos;
import com.mypet.mypet.domain.enums.TipoContato;
import com.mypet.mypet.domain.enums.TipoEmail;
import com.mypet.mypet.domain.enums.TipoEndereco;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Data
@EqualsAndHashCode(of = {"id"})
@MappedSuperclass

public  abstract class Pessoas implements Serializable {

        private static final long serialVersionUID = 1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        protected long id;

        protected String name;
        protected String lastName;
        @Column(unique = true)
        protected String cpf;
        protected String rg;

        @Enumerated(EnumType.STRING)
        protected Generos genero;
        @ElementCollection(fetch =FetchType.EAGER)
        @CollectionTable(name = "Perfis")
        protected Set<Integer> perfil = new HashSet<>();

        @Enumerated(EnumType.STRING)
        protected List<TipoEmail> email;
        @Enumerated(EnumType.STRING)
        protected List <TipoContato>contato;
        @Enumerated(EnumType.STRING)
        protected List <TipoEndereco>enderecos;

        protected LocalDate dataDeNasc;
        @JsonFormat(pattern = "dd/MM/yyyy")
        protected LocalDate dataDeCadastro = LocalDate.now();

}


