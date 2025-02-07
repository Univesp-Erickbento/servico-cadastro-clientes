package com.mypet.mypet.userCase;

import com.mypet.mypet.domain.dto.login.LoginRequest;
import com.mypet.mypet.domain.dto.login.LoginResponse;
import com.mypet.mypet.domain.model.LoginEntity;
import com.mypet.mypet.repositories.LoginRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class LoginService {

    private final JwtEncoder jwtEncoder;
    private final LoginRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginService(JwtEncoder jwtEncoder,
                        LoginRepository userRepository,
                        BCryptPasswordEncoder passwordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(LoginRequest loginRequest) {
        // Verificar se o usuário já existe
        Optional<LoginEntity> user = userRepository.findByNomeUsuario(loginRequest.nomeUsuario());

        // Se o usuário já existir, retorna um erro
        if (user.isPresent()) {
            throw new RuntimeException("Usuário já existe!");
        }

        // Se o usuário não existir, cria um novo
        LoginEntity newUser = new LoginEntity();
        newUser.setNomeUsuario(loginRequest.nomeUsuario());
        newUser.setSenha(passwordEncoder.encode(loginRequest.senha()));  // Senha criptografada

        // Salva o novo usuário no banco
        userRepository.save(newUser);

        // Retorna uma resposta confirmando a criação do usuário
        return "Usuário registrado com sucesso!";
    }

    public LoginResponse login(LoginRequest loginRequest) {
        // Verificar se o usuário existe
        Optional<LoginEntity> user = userRepository.findByNomeUsuario(loginRequest.nomeUsuario());

        // Se o usuário não existir, lançar erro de credenciais
        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("Usuário ou senha inválidos!");
        }

        // Se a autenticação for bem-sucedida, gera o JWT
        return createJwtResponse(user.get());
    }

    private LoginResponse createJwtResponse(LoginEntity user) {
        var now = Instant.now();
        var expiresIn = 300L;  // Tempo de expiração do JWT

        var claims = JwtClaimsSet.builder()
                .issuer("serviço-de-cadastro-BMT")
                .subject(user.getNomeUsuario())  // Definindo o nome de usuário no JWT
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        // Gerar o JWT
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        // Retornar a resposta com o JWT
        return new LoginResponse(jwtValue, expiresIn);
    }

    public String updatePassword(String username, LoginRequest loginRequest) {
        // Verificar se o usuário existe
        Optional<LoginEntity> user = userRepository.findByNomeUsuario(username);

        // Se o usuário não existir, retorna erro
        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        // Atualiza a senha do usuário
        LoginEntity existingUser = user.get();
        existingUser.setSenha(passwordEncoder.encode(loginRequest.senha()));  // Senha criptografada

        // Salva a atualização no banco de dados
        userRepository.save(existingUser);

        // Retorna uma resposta confirmando a atualização
        return "Senha atualizada com sucesso!";
    }

    public String deleteUser(String username) {
        // Verificar se o usuário existe
        Optional<LoginEntity> user = userRepository.findByNomeUsuario(username);

        // Se o usuário não existir, retorna erro
        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        // Excluir o usuário do banco de dados
        userRepository.delete(user.get());

        // Retorna uma resposta confirmando a exclusão
        return "Usuário excluído com sucesso!";
    }
}
