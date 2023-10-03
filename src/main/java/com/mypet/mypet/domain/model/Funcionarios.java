package com.mypet.mypet.domain.model;

import com.mypet.mypet.core.entities.tb_principal.Contatos;
import com.mypet.mypet.core.entities.tb_principal.Enderecos;
import com.mypet.mypet.domain.complementares.Cargos;
import com.mypet.mypet.domain.complementares.Departamento;
import com.mypet.mypet.domain.enums.Generos;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Funcionario")

public class Funcionarios extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long funcionarioId;
    private String funcionarioTipo;
    private String funcionarioReg;
    private Cargos cargo;
    @Enumerated(EnumType.STRING)
    private String funcionarioStatus;
    private Departamento departamento;
    private LocalDate dataDeAdimissao;


    public Funcionarios(final long id, final String name, final String lastName, final String email, final String cpf, final String rg,
                        final Generos genero, final Set<Integer> perfil, final List<Enderecos> enderecos1, final List<Contatos> contatos,
                        final LocalDate dataDeNasc) {
        super(id, name, lastName, email, cpf, rg, genero, perfil, enderecos1, contatos, dataDeNasc);
    }

    public Funcionarios(final long id, final String name, final String lastName, final String email, final String cpf, final String rg,
                        final Generos genero, final Set<Integer> perfil, final List<Enderecos> enderecos1, final List<Contatos> contatos,
                        final LocalDate dataDeNasc, final long funcionarioId, final String funcionarioTipo, final String funcionarioReg,
                        final Cargos cargo, final String funcionarioStatus, final Departamento departamento, final LocalDate dataDeAdimissao) {
        super(id, name, lastName, email, cpf, rg, genero, perfil, enderecos1, contatos, dataDeNasc);
        this.funcionarioId = funcionarioId;
        this.funcionarioTipo = funcionarioTipo;
        this.funcionarioReg = funcionarioReg;
        this.cargo = cargo;
        this.funcionarioStatus = funcionarioStatus;
        this.departamento = departamento;
        this.dataDeAdimissao = dataDeAdimissao;
    }

    public Funcionarios() {

    }
}
