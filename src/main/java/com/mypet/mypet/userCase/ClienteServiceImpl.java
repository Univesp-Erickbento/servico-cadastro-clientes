package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.model.Cliente;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.repositories.ClienteRepository;
import com.mypet.mypet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {


    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}