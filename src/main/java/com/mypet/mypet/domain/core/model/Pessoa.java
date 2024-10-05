package com.mypet.mypet.domain.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.mypet.mypet.domain.enums.*;
import com.mypet.mypet.domain.model.Endereco;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Data
@EqualsAndHashCode(of = {"id"})
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED) // ou SINGLE_TABLE, TABLE_PER_CLASS
public   class Pessoa implements Serializable {

        private static final long serialVersionUID = 1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        protected long id;

        protected String name;
        protected String lastName;
        @Column(unique = true)
        protected String cpf;
        protected String rg;
        protected String genero;
        protected String Perfis;
        protected String email;
        protected String contato;
       // protected String enderecos;

        // Relacionamento um-para-muitos
//        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//        private List<Endereco> enderecos;


//        @Enumerated(EnumType.STRING)
//        protected Generos genero;
//        @ElementCollection(fetch =FetchType.EAGER)
//        @CollectionTable(name = "Perfis")
//        protected Set<Integer> perfil = new HashSet<>();

//        @Enumerated(EnumType.STRING)
//        protected List<TipoEmail> email;
//        @Enumerated(EnumType.STRING)
//        protected List <TipoContato>contato;
//        @Enumerated(EnumType.STRING)
//        protected List <TipoEndereco>enderecos;

        @JsonFormat(pattern = "dd/MM/yyyy")
        protected LocalDate dataDeNasc;
        @JsonFormat(pattern = "dd/MM/yyyy")
        protected LocalDate dataDeCadastro = LocalDate.now();



        public List<Perfis> perfis (Perfis perfil){
                List<Perfis> perfiList = new ArrayList<>();
                perfiList.add(perfil);
                return perfiList;
        }

}


