package com.mypet.mypet.adapters.in.controllers;

import com.mypet.mypet.application.core.domain.model.ClientesEntity;
import com.mypet.mypet.domain.dto.clientedto.ClienteEnvioDTO;
import com.mypet.mypet.userCase.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = {
        "http://45.93.100.30:4200",
        "http://192.168.15.2:4200",
        "http://192.168.15.200:4200",
        "http://localhost:4200"
})
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<ClientesEntity>> listarTodos(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(clienteService.listarTodos(authorizationHeader));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesEntity> buscarPorId(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String authorizationHeader) {
        return clienteService.buscarPorId(id, authorizationHeader)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientesEntity> salvar(@RequestBody ClienteEnvioDTO dto,
                                                 @RequestHeader("Authorization") String authorizationHeader) {

        ClientesEntity clienteSalvo = clienteService.salvar(dto, authorizationHeader);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesEntity> atualizar(@PathVariable Long id,
                                                    @RequestBody ClientesEntity clienteAtualizado,
                                                    @RequestHeader("Authorization") String authorizationHeader) {
        ClientesEntity atualizado = clienteService.atualizar(id, clienteAtualizado, authorizationHeader);
        return (atualizado != null)
                ? ResponseEntity.ok(atualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id,
                                        @RequestHeader("Authorization") String authorizationHeader) {
        clienteService.deletar(id, authorizationHeader);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<ClientesEntity> buscarPorPessoaId(@PathVariable Long pessoaId,
                                                            @RequestHeader("Authorization") String authorizationHeader) {
        return clienteService.buscarPorPessoaId(pessoaId, authorizationHeader)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
