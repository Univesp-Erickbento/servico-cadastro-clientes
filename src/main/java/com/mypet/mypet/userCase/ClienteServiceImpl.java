package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.enums.Status;
import com.mypet.mypet.domain.model.Cliente;
//import com.mypet.mypet.domain.model.Endereco;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.repositories.ClienteRepository;
import com.mypet.mypet.repositories.FuncionarioRepository;
import com.mypet.mypet.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mypet.mypet.domain.core.model.Pessoa;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PessoaRepository pessoaRepository;

    private static final String PESSOA_SERVICE_URL = "http://localhost:9090/api/pessoas";

    @Transactional
    public Cliente salvar(Cliente cliente) {
        String cpf = cliente.getCpf();
        Pessoa pessoaExistente = null;

        try {
            // 1. Tenta obter a Pessoa pelo CPF chamando o serviço de Pessoa
            try {
                ResponseEntity<Pessoa> response = restTemplate.getForEntity(
                        PESSOA_SERVICE_URL + "/cpf/{cpf}", Pessoa.class, cpf
                );


                if (response.getStatusCode() == HttpStatus.OK) {
                    pessoaExistente = response.getBody();
                }
            } catch (HttpClientErrorException e) {
                if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                    // Pessoa não encontrada, continua para criar uma nova
                } else {
                    throw e;
                }
            }

            if (pessoaExistente == null) {
                // 2. Se a Pessoa não for encontrada, cria uma nova
                Pessoa novaPessoa = new Pessoa();
                novaPessoa.setCpf(cpf);
                novaPessoa.setNome(cliente.getNome());
                novaPessoa.setSobrenome(cliente.getSobrenome());
                novaPessoa.setRg(cliente.getRg());
                novaPessoa.setGenero(cliente.getGenero());
                novaPessoa.setPerfis(cliente.getPerfis());
                novaPessoa.setEmail(cliente.getEmail());
                novaPessoa.setContato(cliente.getContato());
                novaPessoa.setDataNascimento(cliente.getDataNascimento());

                // Envia a nova Pessoa para o serviço de Pessoa e obtém a Pessoa criada
                pessoaExistente = restTemplate.postForObject(
                        PESSOA_SERVICE_URL, novaPessoa, Pessoa.class
                );

                // Salva a nova Pessoa no banco de dados local
                pessoaExistente = pessoaRepository.save(pessoaExistente);
            }

            // 3. Associa a Pessoa encontrada ou criada ao Cliente
            cliente.setPessoa(pessoaExistente);

            // Define outros atributos do Cliente
            cliente.setClienteReg(cliente.getClienteReg());
            cliente.setClienteStatus(cliente.getClienteStatus());

        } catch (HttpClientErrorException e) {
            // Tratar exceção de pessoa não encontrada
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Log de pessoa não encontrada
                System.err.println("Pessoa não encontrada: " + e.getMessage());
            } else {
                System.err.println("Erro ao comunicar com o serviço de Pessoa: " + e.getMessage());
                throw new RuntimeException("Falha na comunicação com o serviço de Pessoa.", e);
            }
        } catch (Exception e) {
            System.err.println("Erro ao comunicar com o serviço de Pessoa: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Falha na comunicação com o serviço de Pessoa.", e);
        }

        // 4. Salva o Cliente no repositório e retorna o Cliente salvo
        return clienteRepository.save(cliente);
    }


    private Pessoa convertToEntity(Pessoa pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        // Defina os outros campos conforme necessário...
        return pessoa;
    }
}

