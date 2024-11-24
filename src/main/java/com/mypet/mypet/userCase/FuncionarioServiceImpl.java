package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.enums.Status;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public FuncionarioDTO salvar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = convertToEntity(funcionarioDTO);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return convertToDto(funcionarioSalvo);
    }

    public List<FuncionarioDTO> listarTodos() {
        return funcionarioRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<FuncionarioDTO> buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
                .map(this::convertToDto);
    }

    @Transactional
    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioDTO) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionario.setPessoaId(funcionarioDTO.getPessoaId());
                    funcionario.setFuncionarioTipo(funcionarioDTO.getFuncionarioTipo());
                    funcionario.setFuncionarioReg(funcionarioDTO.getFuncionarioReg());
                    funcionario.setFuncionarioStatus(Status.valueOf(funcionarioDTO.getFuncionarioStatus()));
                    funcionario.setDataDeAdmissao(funcionarioDTO.getDataDeAdmissao());
                    funcionario.setDataDeDemissao(funcionarioDTO.getDataDeDemissao());
                    Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
                    return convertToDto(funcionarioAtualizado);
                })
                .orElse(null);
    }

    @Transactional
    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    private FuncionarioDTO convertToDto(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setPessoaId(funcionario.getPessoaId());
        dto.setFuncionarioTipo(funcionario.getFuncionarioTipo());
        dto.setFuncionarioReg(funcionario.getFuncionarioReg());
        dto.setFuncionarioStatus(funcionario.getFuncionarioStatus().name());
        dto.setDataDeAdmissao(funcionario.getDataDeAdmissao());
        dto.setDataDeDemissao(funcionario.getDataDeDemissao());
        return dto;
    }

    private Funcionario convertToEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setPessoaId(dto.getPessoaId());
        funcionario.setFuncionarioTipo(dto.getFuncionarioTipo());
        funcionario.setFuncionarioReg(dto.getFuncionarioReg());
        funcionario.setFuncionarioStatus(Status.valueOf(dto.getFuncionarioStatus()));
        funcionario.setDataDeAdmissao(dto.getDataDeAdmissao());
        funcionario.setDataDeDemissao(dto.getDataDeDemissao());
        return funcionario;
    }
}
