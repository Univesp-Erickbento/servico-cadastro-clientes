package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.core.model.Pessoa;
import com.mypet.mypet.domain.model.Cliente;
import com.mypet.mypet.domain.model.Funcionario;

import java.time.LocalDate;

public class PessoaService {
    public void processarPessoa(Pessoa pessoa) {
        if (pessoa instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) pessoa;
            // Manipula os campos específicos de Funcionario
            LocalDate dataAdmissao = funcionario.getDataDeAdmissao();

            LocalDate dataDemissao = funcionario.getDataDeDemissao();
            System.out.println("Data de Admissão: " + dataAdmissao);
            System.out.println("Data de Demissão: " + dataDemissao);
        } else if (pessoa instanceof Cliente) {
            Cliente cliente = (Cliente) pessoa;
            // Manipula os campos específicos de Cliente
            System.out.println("Registro do Cliente: " + cliente.getClienteReg());
            System.out.println("Status do Cliente: " + cliente.getClienteStatus());
        } else {
            System.out.println("Tipo de Pessoa desconhecido");
        }
    }
}