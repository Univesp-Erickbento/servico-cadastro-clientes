package com.mypet.mypet.core.entities.tb_principal;

import com.mypet.mypet.domain.enums.TipoEndereco;
import com.mypet.mypet.domain.model.Pessoas;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

//@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
//@EqualsAndHashCode(of = {"enderecoId"})
@Entity
@Table(name = "ENDERECOS")
public class Enderecos implements Serializable {

        private static final long serialVersionUID =1l;




        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private long enderecoId;
    @Enumerated(EnumType.STRING)
    private TipoEndereco enderecoTipo;


        private String logadouro;
        private int numeroCasa;
        private String bairro;
        private String cidade;
        private String uf;
        private String cep;
        private String complemento;
        @ManyToOne
        @JoinColumn(name = "pessoa_id")
        private  Pessoas pessoa;




}
