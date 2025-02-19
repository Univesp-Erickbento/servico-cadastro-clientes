package com.mypet.mypet.controllers;

import com.mypet.mypet.domain.dto.login.LoginRequest;
import com.mypet.mypet.domain.dto.login.LoginResponse;
import com.mypet.mypet.userCase.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")  // Agrupando as rotas relacionadas a autenticação
@CrossOrigin(origins = {"http://192.168.15.2:4200", "http://192.168.15.200:4200", "http://localhost:4200"})  // Adicionando a anotação CORS para todas as rotas
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Endpoint para criar um novo usuário
    @PostMapping("/register")  // POST /auth/register
    public ResponseEntity<String> register(@RequestBody LoginRequest loginRequest) {
        try {
            String response = loginService.register(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para autenticação do usuário (login)
    @PostMapping("/login")  // POST /auth/login
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = loginService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint para atualizar a senha de um usuário
    @PutMapping("/update/{username}")  // PUT /auth/update/{username}
    public ResponseEntity<String> updatePassword(@PathVariable String username, @RequestBody LoginRequest loginRequest) {
        try {
            String response = loginService.updatePassword(username, loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para excluir um usuário
    @DeleteMapping("/delete/{username}")  // DELETE /auth/delete/{username}
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        try {
            String response = loginService.deleteUser(username);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
