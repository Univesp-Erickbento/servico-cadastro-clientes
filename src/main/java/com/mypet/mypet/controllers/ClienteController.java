package com.mypet.mypet.controllers;

import com.mypet.mypet.domain.model.Cliente;
import com.mypet.mypet.userCase.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

//    @GetMapping
//    public ResponseEntity<List<Cliente>> listarTodos() {
//        return new ResponseEntity<>(clienteService.listarTodos(), HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
//        Cliente cliente = clienteService.buscarPorId(id);
//        if (cliente != null) {
//            return new ResponseEntity<>(cliente, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        try {
            Cliente clienteSalvo = clienteService.salvar(cliente);
            return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log de erro detalhado
            System.err.println("Erro ao salvar o cliente: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
//        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
//        if (clienteAtualizado != null) {
//            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        clienteService.deletar(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    }
}