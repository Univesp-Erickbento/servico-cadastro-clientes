package com.mypet.mypet.domain.model;

import com.mypet.mypet.domain.complementares.Regioes;
import com.mypet.mypet.domain.enums.Status;
import com.mypet.mypet.domain.enums.TipoTutor;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Tutor")
public class Tutores extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;



    @Enumerated(EnumType.STRING)
    private TipoTutor tipo;
    @ManyToOne
    @JoinColumn(name = "Regiao_id")
    private Regioes região;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch =FetchType.EAGER)
    @CollectionTable(name = "Status")
    protected Set<Integer> status = new HashSet<>();
   // private Status status;


}
