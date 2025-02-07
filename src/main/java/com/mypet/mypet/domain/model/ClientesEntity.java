package com.mypet.mypet.domain.model;

import com.mypet.mypet.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@DiscriminatorValue("cliente")
@Entity
@Table(name = "tb_clientes")
public class ClientesEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected long id;


   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private long pessoaId;

    private String clienteReg;

    @Enumerated(EnumType.STRING)
    private Status clienteStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getClienteReg() {
        return clienteReg;
    }

    public void setClienteReg(String clienteReg) {
        this.clienteReg = clienteReg;
    }

    public Status getClienteStatus() {
        return clienteStatus;
    }

    public void setClienteStatus(Status clienteStatus) {
        this.clienteStatus = clienteStatus;
    }
}
