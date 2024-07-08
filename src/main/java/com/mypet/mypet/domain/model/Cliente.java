package com.mypet.mypet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mypet.mypet.domain.core.model.Pessoas;
import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoas implements Serializable {

    private static final long serialVersionUID = 1l;

    private String clienteReg;

    @Enumerated(EnumType.STRING)
    private Status clienteStatus;


    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataDeCadastro = LocalDate.now();

}
