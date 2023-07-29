package com.mypet.mypet.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enderecoId"})
@Entity
@Table(name = "ENDERECOS")
public class Enderecos implements Serializable {

        private static final long serialVersionUID =1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long enderecoId;

        private String enderecoTipo;
        private String logadouro;
        private int numeroCasa;
        private String bairro;
        private String cidade;
        private String uf;
        private String cep;
         @ManyToOne
         @JoinColumn(name = "cpf")
         private Pessoas enderecoCpf;

       // @ManyToOne
      //  @JoinColumn(name = "enderecos_id")

}
