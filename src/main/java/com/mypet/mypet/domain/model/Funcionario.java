package com.mypet.mypet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mypet.mypet.domain.core.model.Pessoa;
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
//@DiscriminatorValue("funcionario")
@Entity
@Table(name = "Funcionarios")
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pessoa_id", nullable = false) // Coluna na tabela clientes que referencia a tabela pessoas
//    private Pessoa pessoaId; // Relacionamento com a tabela Pessoas

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeAdimissao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeDemisao;

}
