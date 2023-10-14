package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.model.Funcionarios;
import com.mypet.mypet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioUserCase {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public List<FuncionarioDTO> findAll() {
        List<Funcionarios> result = funcionarioRepository.findAll();
        List<FuncionarioDTO> dto = result.stream().map(x -> new FuncionarioDTO(x)).toList();
        return dto;
    }
        public Funcionarios findById(Long id){
            Optional<Funcionarios> obj = funcionarioRepository.findById(id);
            return obj.orElse(null);

        }
}
