package com.mypet.mypet.domain.model;

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
@Table(name = "tb_clientes")
public class ClientesEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;


   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private long pessoaId;

    private String clienteReg;

    @Enumerated(EnumType.STRING)
    private Status clienteStatus;



}
