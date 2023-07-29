package com.mypet.mypet.core.entities.tb_principal;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"contatoId"})
@Entity
@Table(name = "CONTATOS")
public class Contatos implements Serializable {

        private static final long serialVersionUID =1l;



        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long contatoId;

        private String contatoTipo;
        private String contatoNumero;

//        @ManyToOne
//        @JoinColumn(name = "PessoaContatoId")
//        private String contatoPessoa;

       // @ManyToOne
      //  @JoinColumn(name = "enderecos_id")

}
