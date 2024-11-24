package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.model.Cliente;
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
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Método para buscar um cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Método para atualizar um cliente existente
    @Transactional
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setPessoaId(clienteAtualizado.getPessoaId());
            cliente.setClienteReg(clienteAtualizado.getClienteReg());
            cliente.setClienteStatus(clienteAtualizado.getClienteStatus());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // Método para deletar um cliente por ID
    @Transactional
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
