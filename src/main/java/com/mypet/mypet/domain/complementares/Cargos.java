package com.mypet.mypet.domain.complementares;

public class Cargos {
    private long id;
    private String cargo;

    public Cargos() {
    }

    public Cargos(final long id, final String cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(final String cargo) {
        this.cargo = cargo;
    }
}
