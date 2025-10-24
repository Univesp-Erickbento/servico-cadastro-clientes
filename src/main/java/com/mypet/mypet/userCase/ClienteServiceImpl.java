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
        cliente.setNome(dto.nome());
        cliente.setSobrenome(dto.sobrenome());
        cliente.setCpf(dto.cpf());
        cliente.setRg(dto.rg());
        cliente.setGenero(dto.genero());
        cliente.setPerfis(dto.perfis());
        cliente.setEmail(dto.email());
        cliente.setContato(dto.contato());
        cliente.setDataNascimento(dto.dataNascimento());
        cliente.setPessoaId(dto.pessoaId());
        cliente.setClienteReg(dto.clienteReg());
        cliente.setAtivo(dto.ativo() != null ? dto.ativo() : true);

        return clienteRepository.save(cliente);
    }

    public List<ClientesEntity> listarTodos(String authorizationHeader) {
        return clienteRepository.findAll();
    }

    public Optional<ClientesEntity> buscarPorId(Long id, String authorizationHeader) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public ClientesEntity atualizar(Long id, ClientesEntity clienteAtualizado, String authorizationHeader) {
        Optional<ClientesEntity> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            ClientesEntity cliente = clienteExistente.get();

            cliente.setNome(clienteAtualizado.getNome());
            cliente.setSobrenome(clienteAtualizado.getSobrenome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setRg(clienteAtualizado.getRg());
            cliente.setGenero(clienteAtualizado.getGenero());
            cliente.setPerfis(clienteAtualizado.getPerfis());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setContato(clienteAtualizado.getContato());
            cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
            cliente.setPessoaId(clienteAtualizado.getPessoaId());
            cliente.setClienteReg(clienteAtualizado.getClienteReg());
            cliente.setAtivo(clienteAtualizado.getAtivo());

            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Transactional
    public void deletar(Long id, String authorizationHeader) {
        clienteRepository.deleteById(id);
    }

    public Optional<ClientesEntity> buscarPorPessoaId(Long pessoaId, String authorizationHeader) {
        return clienteRepository.findByPessoaId(pessoaId);
    }
}
