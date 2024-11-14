package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.core.model.Pessoa;
import com.mypet.mypet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String ENDERECO_SERVICE_URL = "http://endereco-service/api/enderecos";

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(Pessoa pessoa) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findByCpf(pessoa.getCpf());
        // Se a pessoa já existe, retorna ela, caso contrário salva a nova
        return pessoaExistente.orElseGet(() -> pessoaRepository.save(pessoa));
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId(id);
            return pessoaRepository.save(pessoa);
        } else {
            return null; // Pessoa não encontrada, pode retornar ResponseEntity com status 404
        }
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Optional<Pessoa> buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }
}
