package com.mypet.mypet.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_login")
public class LoginEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;


   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private long pessoaId;

    private String nomeUsario;


    private String senha;

    //@Enumerated(EnumType.STRING)
    private String perfis;

}
