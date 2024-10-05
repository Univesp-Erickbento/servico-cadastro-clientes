package com.mypet.mypet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mypet.mypet.domain.core.model.Pessoa;
import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;


    private String clienteReg;

    @Enumerated(EnumType.STRING)
    private Status clienteStatus;

//    // Relacionamento um-para-muitos
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Endereco> enderecos;

    // Relacionamento bidirecional com Endereco
    @OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

}
