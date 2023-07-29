package com.mypet.mypet.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class Funcionarios extends Pessoas{
    private long funcionarioId;
    private String funcionarioTipo;
    private String funcionarioReg;
    private String cargo;
    private String funcionarioStatus;
    private String departamento;
    private LocalDate dataDeAdimissao;
}
