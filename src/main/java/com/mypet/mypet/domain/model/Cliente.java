package com.mypet.mypet.domain.model;

import com.mypet.mypet.domain.core.model.Pessoa;
import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@DiscriminatorValue("cliente")
@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pessoa_id", nullable = false) // Coluna na tabela clientes que referencia a tabela pessoas
//    private Pessoa pessoaId; // Relacionamento com a tabela Pessoas

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    private String clienteReg;

    @Enumerated(EnumType.STRING)
    private Status clienteStatus;



//    // Relacionamento um-para-muitos
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Endereco> enderecos;

    // Relacionamento bidirecional com Endereco
//    @OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Endereco> enderecos;



}
