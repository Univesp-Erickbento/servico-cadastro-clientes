package com.mypet.mypet.controllers;

import com.mypet.mypet.domain.model.ClientesEntity;
import com.mypet.mypet.userCase.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClientesEntity>> listarTodos() {
        List<ClientesEntity> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClientesEntity> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para adicionar um novo cliente
    @PostMapping
    public ResponseEntity<ClientesEntity> salvar(@RequestBody ClientesEntity cliente) {
        ClientesEntity clienteSalvo = clienteService.salvar(cliente);
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClientesEntity> atualizar(@PathVariable Long id, @RequestBody ClientesEntity clientesEntity) {
        ClientesEntity clienteAtualizado = clienteService.atualizar(id, clientesEntity);
        return clienteAtualizado != null ? ResponseEntity.ok(clienteAtualizado) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para deletar um cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
