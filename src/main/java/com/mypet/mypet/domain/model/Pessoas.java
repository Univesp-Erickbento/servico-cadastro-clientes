package com.mypet.mypet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mypet.mypet.core.entities.tb_principal.Contatos;
import com.mypet.mypet.core.entities.tb_principal.Enderecos;
import com.mypet.mypet.domain.enums.Generos;
import com.mypet.mypet.domain.enums.Perfis;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@ToString
@Data
//@Setter
//@Getter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "Pessoas")
public abstract class Pessoas implements Serializable {

        private static final long serialVersionUID = 1l;


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        protected long id;

        protected String name;
        protected String lastName;
        protected String email;
        @Column(unique = true)
        protected String cpf;
        protected String rg;
        @Enumerated(EnumType.STRING)
        protected Generos genero;

        @ElementCollection(fetch =FetchType.EAGER)
        @CollectionTable(name = "Perfis")
        protected Set<Integer> perfil = new HashSet<>();
        protected LocalDate dataDeNasc;

     //  @JsonFormat(pattern = "dd/MM/yyyy")
        protected LocalDate dataDeCadastro = LocalDate.now();

        protected Pessoas(final long id, final String name, final String lastName, final String email, final String cpf,
                          final String rg, final Generos genero,  final LocalDate dataDeNasc) {
                this.id = id;
                this.name = name;
                this.lastName = lastName;
                this.email = email;
                this.cpf = cpf;
                this.rg = rg;
                this.genero = genero;
                this.dataDeNasc = dataDeNasc;
        }

        protected Pessoas(){
         addPerfil(Perfis.CLIENTE);}

        public long getId() {
                return this.id;
        }

        public void setId(final long id) {
                this.id = id;
        }

        public String getName() {
                return this.name;
        }

        public void setName(final String name) {
                this.name = name;
        }

        public String getLastName() {
                return this.lastName;
        }

        public void setLastName(final String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(final String email) {
                this.email = email;
        }

        public String getCpf() {
                return this.cpf;
        }

        public void setCpf(final String cpf) {
                this.cpf = cpf;
        }

        public String getRg() {
                return this.rg;
        }

        public void setRg(final String rg) {
                this.rg = rg;
        }

        public Generos getGenero() {
                return this.genero;
        }

        public void setGenero(final Generos genero) {
                this.genero = genero;
        }

        public Set<Perfis> getPerfil() {
                return this.perfil.stream().map(x-> Perfis.toEnum(x)).collect(Collectors.toSet());
        }

        public void addPerfil(final Perfis perfil) {
                this.perfil.add(perfil.getCodigo());
        }

        public LocalDate getDataDeNasc() {
                return this.dataDeNasc;
        }

        public void setDataDeNasc(final LocalDate dataDeNasc) {
                this.dataDeNasc = dataDeNasc;
        }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoas pessoas)) return false;
        return id == pessoas.id && Objects.equals(cpf, pessoas.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}


