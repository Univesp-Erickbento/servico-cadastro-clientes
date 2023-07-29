package com.mypet.mypet.core.entities.tb_principal;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@ToString
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "Pessoas")
public class Pessoas implements Serializable {

        private static final long serialVersionUID = 1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long id;

        private String name;
        private String lastName;
        private String email;
        private String cpf;
        private String rg;
        private String genero;
        private String enderecos;
        private String contatos;

        //
//       @OneToMany(mappedBy = "enderecoCpf")
//        private List<Enderecos> enderecos1 = new ArrayList<>();
//
//        @OneToMany(mappedBy = "contatoCpf")
//        private List<Contatos> contatos1 = new ArrayList<>();
        private LocalDate dataDeNasc;
        private Timestamp dataDeCadastro;



}
