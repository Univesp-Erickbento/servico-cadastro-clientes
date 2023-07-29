package com.mypet.mypet.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class Clientes extends Pessoas {
    private long ClienteId;
    private String clienteTipo;
    private String região;
    private String clienteStatus;

    public Clientes(com.mypet.mypet.core.entities.Pessoas x) {
    }
}
