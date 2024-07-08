package com.mypet.mypet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mypet.mypet.domain.core.model.Pessoas;
import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Funcionarios")
public class Funcionario extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;

    private String funcionarioTipo;

    private String funcionarioReg;
//    @ManyToOne
//    @JoinColumn(name = "Cargo_Id")
//    private Cargos cargo;

    @Enumerated(EnumType.STRING)
    private Status funcionarioStatus;


//    @ManyToOne
//    @JoinColumn(name = "Departamento_Id")
//    private Departamento departamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCadastro = LocalDate.now();
    private LocalDate dataDeAdimissao;
    private LocalDate dataDeDemisao;

}
