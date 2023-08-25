package com.mypet.mypet.core.entities.tb_relacionamentos;

import com.mypet.mypet.core.entities.tb_pk.PessoaContatoPK;
import com.mypet.mypet.core.entities.tb_principal.Contatos;
import com.mypet.mypet.core.entities.tb_principal.Pessoas;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "PessoaContato")
@Embeddable
public class PessoaContato implements Serializable {

        private static final long serialVersionUID = 1l;



        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @EmbeddedId
      private  PessoaContatoPK id = new PessoaContatoPK();

        //
//       @OneToMany(mappedBy = "enderecoCpf")
//        private List<Enderecos> enderecos1 = new ArrayList<>();
//
//        @OneToMany(mappedBy = "contatoCpf")
//        private List<Contatos> contatos1 = new ArrayList<>();



}
