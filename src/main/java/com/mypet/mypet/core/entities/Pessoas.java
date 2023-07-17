package com.mypet.mypet.core.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "Pessoas")
public class Pessoas implements Serializable {

        private static final long serialVersionUID =1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long id;

        private String name;
        private String lastName;
        private String email;
        private String cpf;
        private String rg;

       // @ManyToOne
      //  @JoinColumn(name = "enderecos_id")
        private String enderecos;
        private String contatos;
        private LocalDate dataDeNasc;

}
