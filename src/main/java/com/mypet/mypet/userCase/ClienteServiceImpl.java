package com.mypet.mypet.userCase;

import com.mypet.mypet.application.core.domain.model.ClientesEntity;
import com.mypet.mypet.adapters.out.repositories.ClienteRepository;
import com.mypet.mypet.domain.dto.clientedto.ClienteEnvioDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClientesEntity salvar(ClienteEnvioDTO dto, String authorizationHeader) {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setPessoaId(dto.pessoaId());
        cliente.setClienteReg(dto.clienteReg());
        cliente.setClienteStatus(dto.clienteStatus());
        return clienteRepository.save(cliente);
    }

    @Transactional
    public ClientesEntity atualizar(Long id, ClientesEntity clienteAtualizado, String authorizationHeader) {
        Optional<ClientesEntity> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            ClientesEntity cliente = clienteExistente.get();
            cliente.setPessoaId(clienteAtualizado.getPessoaId());
            cliente.setClienteReg(clienteAtualizado.getClienteReg());
            cliente.setClienteStatus(clienteAtualizado.getClienteStatus());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public List<ClientesEntity> listarTodos(String authorizationHeader) {
        return clienteRepository.findAll();
    }

    public Optional<ClientesEntity> buscarPorId(Long id, String authorizationHeader) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void deletar(Long id, String authorizationHeader) {
        clienteRepository.deleteById(id);
    }

    public Optional<ClientesEntity> buscarPorPessoaId(Long pessoaId, String authorizationHeader) {
        return clienteRepository.findByPessoaId(pessoaId);
    }
}
