package com.mypet.mypet.domain.dto.clientedto;

import java.time.LocalDate;

public record ClienteEnvioDTO(
        String nome,
        String sobrenome,
        String cpf,
        String rg,
        String genero,
        String perfis,
        String email,
        String contato,
        LocalDate dataNascimento,
        Long pessoaId,
        String clienteReg,
        //Boolean ativo
        String clienteStatus
) {}
