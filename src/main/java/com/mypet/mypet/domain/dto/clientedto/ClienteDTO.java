package com.mypet.mypet.domain.dto.clientedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private Long pessoaId;
    private String clienteReg;

//    public void setPessoa(long id) {
//    }
}
