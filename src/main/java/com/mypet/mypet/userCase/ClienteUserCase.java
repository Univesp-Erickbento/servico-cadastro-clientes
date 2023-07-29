package com.mypet.mypet.userCase;

import com.mypet.mypet.core.entities.Pessoas;
import com.mypet.mypet.dto.Cliente;
import com.mypet.mypet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUserCase {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> findAll(){
    List<Pessoas> result = clienteRepository.findAll();
    List<Cliente> dto = result.stream().map(x -> new Cliente(x)).toList();
    return dto;
}

}
