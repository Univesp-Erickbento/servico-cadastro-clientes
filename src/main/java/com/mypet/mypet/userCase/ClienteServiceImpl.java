package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.model.Cliente;
//import com.mypet.mypet.domain.model.Endereco;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.repositories.ClienteRepository;
import com.mypet.mypet.repositories.FuncionarioRepository;
import com.mypet.mypet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mypet.mypet.domain.core.model.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
//public class ClienteServiceImpl {
//
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    public List<Cliente> listarTodos() {
//        return clienteRepository.findAll();
//    }
//
//    public Cliente salvar(Cliente cliente) {
//
// //       List<Endereco> enderecoList = new ArrayList<>();
//
//        //cliente.setId(null);
//        cliente.setClienteReg(cliente.getClienteReg());
//        //cliente.setClienteStatus("");
//        cliente.setCpf(cliente.getCpf());
//        //cliente.setContato();
//        cliente.setRg(cliente.getRg());
//     //   cliente.setDataDeCadastro(LocalDate.now());
//        //cliente.setDataDeNasc();
//        cliente.setEmail(cliente.getEmail());
//       // cliente.setPessoaId(cliente.getPessoaId());
//        cliente.setGenero(cliente.getGenero());
//        cliente.setSobrenome(cliente.getSobrenome());
//        cliente.setNome(cliente.getNome());
//        cliente.setPerfis(cliente.getPerfis());
//        cliente.setContato(cliente.getContato());
//     //   cliente.setEnderecos(enderecoList);
//
//        return clienteRepository.save(cliente);
//    }
//
//    public Cliente buscarPorId(Long id) {
//        return clienteRepository.findById(id).orElse(null);
//    }
//
//    public Cliente atualizar(Long id, Cliente cliente) {
//        if (clienteRepository.existsById(id)) {
//            cliente.setId(id);
//            return clienteRepository.save(cliente);
//        } else {
//            return null;
//        }
//    }
//
//    public void deletar(Long id) {
//        clienteRepository.deleteById(id);
//    }

@Service
public class ClienteServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository; // Repositório para Pessoa

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        Pessoa pessoa = cliente.getPessoa();
        if (pessoa != null) {
            Pessoa pessoaSalva = pessoaRepository.save(pessoa); // Salva a entidade Pessoa primeiro
            cliente.setPessoa(pessoaSalva);
        }
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
