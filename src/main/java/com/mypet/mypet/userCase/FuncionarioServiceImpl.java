package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        if (funcionarioRepository.existsById(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        } else {
            return null;
        }
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}