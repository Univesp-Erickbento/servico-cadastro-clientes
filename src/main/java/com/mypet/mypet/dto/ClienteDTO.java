package com.mypet.mypet.dto;

import com.mypet.mypet.core.entities.tb_principal.Pessoas;
import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

private long id;
private String name;
private String lastName;
private String email;
private String cpf;
private LocalDate dataDeNasc;



    public ClienteDTO(Pessoas cliente) {

        id = cliente.getId();
        name = cliente.getName();
        lastName = cliente.getLastName();
        email = cliente.getEmail();
        dataDeNasc = cliente.getDataDeNasc();
        cpf = cliente.getCpf();

       // Pessoas.builder().id(cliente.getId()).name(cliente.getName()).build();

        
        
    }
}