package com.mypet.mypet.domain.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.mypet.mypet.domain.enums.*;
//import com.mypet.mypet.domain.model.Endereco;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Data
@EqualsAndHashCode(of = {"id"})
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED) // ou SINGLE_TABLE, TABLE_PER_CLASS
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "perfis")
@Entity
@Table(name = "pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected long id;

        protected String nome;
        protected String sobrenome;
        protected String cpf;
        protected String rg;
        protected String genero;
        protected String Perfis;
        protected String email;
        protected String contato;
        protected LocalDate dataNascimento;
        protected LocalDate dataCadastro = LocalDate.now();





        public List<Perfis> perfis (Perfis perfil){
                List<Perfis> perfiList = new ArrayList<>();
                perfiList.add(perfil);
                return perfiList;
        }

}


