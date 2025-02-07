package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.model.PessoasEntity;
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
    public PessoasEntity salvar(PessoasEntity pessoa, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return pessoaRepository.save(pessoa);
    }

    // Método para listar todas as pessoas
    public List<PessoasEntity> listarTodas() {
        return pessoaRepository.findAll();
    }

    // Método para buscar uma pessoa por ID
    public Optional<PessoasEntity> buscarPorId(Long id, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return pessoaRepository.findById(id);
    }

    // Método para buscar uma pessoa por CPF
    public Optional<PessoasEntity> buscarPorCpf(String cpf, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        return pessoaRepository.findByCpf(cpf);
    }

    // Método para atualizar uma pessoa existente
    @Transactional
    public PessoasEntity atualizar(Long id, PessoasEntity pessoaAtualizada, String authorizationHeader) {
        Optional<PessoasEntity> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            PessoasEntity pessoasEntity = pessoaExistente.get();
            pessoasEntity.setNome(pessoaAtualizada.getNome());
            pessoasEntity.setSobrenome(pessoaAtualizada.getSobrenome());
            pessoasEntity.setCpf(pessoaAtualizada.getCpf());
            pessoasEntity.setRg(pessoaAtualizada.getRg());
            pessoasEntity.setGenero(pessoaAtualizada.getGenero());
            pessoasEntity.setPerfis(pessoaAtualizada.getPerfis());
            pessoasEntity.setEmail(pessoaAtualizada.getEmail());
            pessoasEntity.setContato(pessoaAtualizada.getContato());
            pessoasEntity.setDataNascimento(pessoaAtualizada.getDataNascimento());
            pessoasEntity.setDataCadastro(pessoaAtualizada.getDataCadastro());
            // Use o token de autorização conforme necessário
            return pessoaRepository.save(pessoasEntity);
        }
        return null;
    }

    // Método para deletar uma pessoa por ID
    @Transactional
    public void deletar(Long id, String authorizationHeader) {
        // Use o token de autorização conforme necessário
        pessoaRepository.deleteById(id);
    }
}
