package com.mypet.mypet.controllers;
import com.mypet.mypet.domain.model.Funcionario;
import com.mypet.mypet.userCase.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return new ResponseEntity<>(funcionarioService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.salvar(funcionario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(id, funcionario);
        if (funcionarioAtualizado != null) {
            return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}