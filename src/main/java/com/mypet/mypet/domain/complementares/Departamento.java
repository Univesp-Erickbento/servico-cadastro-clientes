package com.mypet.mypet.domain.complementares;

public class Departamento {

    private long id;
    private String departamento;

    public Departamento() {
    }

    public Departamento(final long id, final String departamento) {
        this.id = id;
        this.departamento = departamento;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(final String departamento) {
        this.departamento = departamento;
    }
}
