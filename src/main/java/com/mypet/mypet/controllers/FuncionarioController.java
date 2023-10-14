package com.mypet.mypet.controllers;

import com.mypet.mypet.domain.dto.FuncionarioDTO;
import com.mypet.mypet.domain.model.Funcionarios;
import com.mypet.mypet.repositories.FuncionarioRepository;
import com.mypet.mypet.userCase.FuncionarioUserCase;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioUserCase funcionarioUserCase;

    @Autowired
    FuncionarioRepository funcionarioRepository;

//    @PostMapping("/funcionarios")
//    public ResponseEntity<Funcionarios> saveFuncionario (@RequestBody @Valid FuncionarioRecordDto funcionarioRecordDto) {
//        var funcionario = new Funcionarios();
//        BeanUtils.copyProperties(funcionarioRecordDto, funcionario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
//    }
   // @GetMapping
   // public List<FuncionarioDTO> findAll(){
        //List<FuncionarioDTO> result = clienteUserCase.findAll();
      // List<Cliente> dto = result.stream().map(cliente -> new Cliente(cliente)).toList();
      //  return result;
    //}

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
        Funcionarios obj = funcionarioUserCase.findById(id);
        // List<Cliente> dto = result.stream().map(cliente -> new Cliente(cliente)).toList();
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }
}
