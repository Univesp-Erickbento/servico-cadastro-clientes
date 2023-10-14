package com.mypet.mypet.domain.model;

import com.mypet.mypet.core.entities.tb_principal.Contatos;
import com.mypet.mypet.core.entities.tb_principal.Enderecos;
import com.mypet.mypet.domain.complementares.Cargos;
import com.mypet.mypet.domain.complementares.Departamento;
import com.mypet.mypet.domain.enums.Generos;
import com.mypet.mypet.domain.enums.Perfis;
import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Funcionario")

public class Funcionarios extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;

    private String funcionarioTipo;
    private String funcionarioReg;
    @ManyToOne
    @JoinColumn(name = "Cargo_Id")
    private Cargos cargo;
    @Enumerated(EnumType.STRING)
    private Status funcionarioStatus;
    @ManyToOne
    @JoinColumn(name = "Departamento_Id")
    private Departamento departamento;
    private LocalDate dataDeAdimissao;


}
