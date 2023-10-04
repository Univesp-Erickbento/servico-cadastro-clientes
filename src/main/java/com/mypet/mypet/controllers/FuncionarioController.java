package com.mypet.mypet.controllers;

import com.mypet.mypet.domain.dto.ClienteDTO;
import com.mypet.mypet.domain.dto.FuncionarioRecordDto;
import com.mypet.mypet.domain.model.Funcionarios;
import com.mypet.mypet.repositories.FuncionarioRepository;
import com.mypet.mypet.userCase.ClienteUserCase;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class FuncionarioController {

    @Autowired
    private ClienteUserCase clienteUserCase;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/funcionario")
    public ResponseEntity<Funcionarios> saveFuncionario (@RequestBody @Valid FuncionarioRecordDto funcionarioRecordDto) {
        var funcionario = new Funcionarios();
        BeanUtils.copyProperties(funcionarioRecordDto, funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
    }
    @GetMapping
    public List<ClienteDTO> findAll(){
        List<ClienteDTO> result = clienteUserCase.findAll();
      // List<Cliente> dto = result.stream().map(cliente -> new Cliente(cliente)).toList();
        return result;
    }

}
