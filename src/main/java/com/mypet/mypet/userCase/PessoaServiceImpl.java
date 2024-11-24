package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.model.Pessoa;
import com.mypet.mypet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Método para salvar uma pessoa
    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Método para listar todas as pessoas
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // Método para buscar uma pessoa por ID
    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    // Método para buscar uma pessoa por CPF
    public Optional<Pessoa> buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    // Método para atualizar uma pessoa existente
    @Transactional
    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            Pessoa pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setSobrenome(pessoaAtualizada.getSobrenome());
            pessoa.setCpf(pessoaAtualizada.getCpf());
            pessoa.setRg(pessoaAtualizada.getRg());
            pessoa.setGenero(pessoaAtualizada.getGenero());
            pessoa.setPerfis(pessoaAtualizada.getPerfis());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setContato(pessoaAtualizada.getContato());
            pessoa.setDataNascimento(pessoaAtualizada.getDataNascimento());
            pessoa.setDataCadastro(pessoaAtualizada.getDataCadastro());
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    // Método para deletar uma pessoa por ID
    @Transactional
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
