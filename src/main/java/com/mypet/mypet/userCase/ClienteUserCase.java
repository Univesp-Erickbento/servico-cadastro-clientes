package com.mypet.mypet.userCase;

import com.mypet.mypet.core.entities.tb_principal.Pessoas;
import com.mypet.mypet.domain.dto.ClienteDTO;
import com.mypet.mypet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUserCase {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteDTO> findAll(){
    List<Pessoas> result = clienteRepository.findAll();
    List<ClienteDTO> dto = result.stream().map(x -> new ClienteDTO(x)).toList();
    return dto;
}

}
