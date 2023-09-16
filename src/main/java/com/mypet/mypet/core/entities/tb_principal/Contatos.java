package com.mypet.mypet.core.entities.tb_principal;

import com.mypet.mypet.domain.enums.TipoContato;
import com.mypet.mypet.domain.model.Pessoas;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

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
        private long id;

        private String contato;
        @Enumerated(EnumType.STRING)
        private TipoContato contatoTipo;

        @ManyToOne
        @JoinColumn(name = "PessoaId")
        private Pessoas PessoaId;

       // @ManyToOne
      //  @JoinColumn(name = "enderecos_id")



}
