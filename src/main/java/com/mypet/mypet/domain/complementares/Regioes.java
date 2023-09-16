package com.mypet.mypet.domain.complementares;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Regioes implements Serializable {

    private static final long serialVersionUID = 1l;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;

    protected String regiao;

    public Regioes() {
    }

    public Regioes(final long id, final String regiao) {
        this.id = id;
        this.regiao = regiao;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public void setRegiao(final String regiao) {
        this.regiao = regiao;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Regioes regioes)) return false;
        return id == regioes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
