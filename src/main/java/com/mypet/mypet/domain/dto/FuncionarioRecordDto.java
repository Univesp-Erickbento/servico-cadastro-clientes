package com.mypet.mypet.domain.dto;

import com.mypet.mypet.domain.complementares.Cargos;

import java.time.LocalDate;

public record FuncionarioRecordDto( Long funcionarioId, String funcionarioTipo, String funcionarioReg, Cargos cargo,
                                   LocalDate dataDeAdimissao) {
}
