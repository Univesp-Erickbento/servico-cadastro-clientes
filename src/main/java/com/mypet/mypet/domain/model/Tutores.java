package com.mypet.mypet.domain.model;

import com.mypet.mypet.domain.complementares.Regioes;
import com.mypet.mypet.domain.enums.Status;
import com.mypet.mypet.domain.enums.TipoTutor;
import jakarta.persistence.*;

import java.io.Serializable;

public class Tutores extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoTutor tipo;
    @ManyToOne
    @JoinColumn(name = "Regiao_id")
    private Regioes região;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tutores(Pessoas x) {
    }
}
