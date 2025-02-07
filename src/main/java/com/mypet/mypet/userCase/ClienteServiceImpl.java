package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.model.ClientesEntity;
import com.mypet.mypet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para salvar um cliente
    @Transactional
    public ClientesEntity salvar(ClientesEntity cliente, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return clienteRepository.save(cliente);
    }

    // Método para listar todos os clientes
    public List<ClientesEntity> listarTodos(String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return clienteRepository.findAll();
    }

    // Método para buscar um cliente por ID
    public Optional<ClientesEntity> buscarPorId(Long id, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return clienteRepository.findById(id);
    }

    // Método para atualizar um cliente existente
    @Transactional
    public ClientesEntity atualizar(Long id, ClientesEntity clienteAtualizado, String authorizationHeader) {
        Optional<ClientesEntity> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            ClientesEntity cliente = clienteExistente.get();
            cliente.setPessoaId(clienteAtualizado.getPessoaId());
            cliente.setClienteReg(clienteAtualizado.getClienteReg());
            cliente.setClienteStatus(clienteAtualizado.getClienteStatus());
            // Use o token de autorização conforme necessário
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // Método para deletar um cliente por ID
    @Transactional
    public void deletar(Long id, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        clienteRepository.deleteById(id);
    }
}
