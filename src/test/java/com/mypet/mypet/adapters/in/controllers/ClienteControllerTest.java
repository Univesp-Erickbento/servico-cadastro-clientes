
package com.mypet.mypet.adapters.in.controllers;

import com.mypet.mypet.application.core.domain.model.ClientesEntity;
import com.mypet.mypet.domain.dto.clientedto.ClienteEnvioDTO;
import com.mypet.mypet.userCase.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Mock
    private ClienteServiceImpl clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private String authorizationHeader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorizationHeader = "Bearer token_teste";
    }

    @Test
    void deveListarTodosClientes() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setId(1L);
        cliente.setPessoaId(123L);

        when(clienteService.listarTodos(authorizationHeader)).thenReturn(Arrays.asList(cliente));

        ResponseEntity<List<ClientesEntity>> response = clienteController.listarTodos(authorizationHeader);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(clienteService, times(1)).listarTodos(authorizationHeader);
    }

    @Test
    void deveBuscarClientePorIdExistente() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setId(1L);

        when(clienteService.buscarPorId(1L, authorizationHeader)).thenReturn(Optional.of(cliente));

        ResponseEntity<ClientesEntity> response = clienteController.buscarPorId(1L, authorizationHeader);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
        verify(clienteService).buscarPorId(1L, authorizationHeader);
    }

    @Test
    void deveRetornarNotFoundAoBuscarClientePorIdInexistente() {
        when(clienteService.buscarPorId(1L, authorizationHeader)).thenReturn(Optional.empty());

        ResponseEntity<ClientesEntity> response = clienteController.buscarPorId(1L, authorizationHeader);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clienteService).buscarPorId(1L, authorizationHeader);
    }

    @Test
    void deveSalvarClienteComSucesso() {
        ClienteEnvioDTO dto = new ClienteEnvioDTO(
                "João",
                "Silva",
                "12345678900",
                "MG123456",
                "MASCULINO",
                "USER",
                "joao@email.com",
                "11999999999",
                LocalDate.of(1990, 1, 1),
                123L,
                "REG-001",
                "ATIVO"
        );

        ClientesEntity clienteSalvo = new ClientesEntity();
        clienteSalvo.setId(10L);

        when(clienteService.salvar(dto, authorizationHeader)).thenReturn(clienteSalvo);

        ResponseEntity<ClientesEntity> response = clienteController.salvar(dto, authorizationHeader);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(clienteSalvo, response.getBody());
        verify(clienteService).salvar(dto, authorizationHeader);
    }
    @Test
    void deveAtualizarClienteComSucesso() {
        ClientesEntity clienteAtualizado = new ClientesEntity();
        clienteAtualizado.setId(1L);

        when(clienteService.atualizar(1L, clienteAtualizado, authorizationHeader)).thenReturn(clienteAtualizado);

        ResponseEntity<ClientesEntity> response = clienteController.atualizar(1L, clienteAtualizado, authorizationHeader);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteAtualizado, response.getBody());
        verify(clienteService).atualizar(1L, clienteAtualizado, authorizationHeader);
    }

    @Test
    void deveRetornarNotFoundAoAtualizarClienteInexistente() {
        ClientesEntity cliente = new ClientesEntity();

        when(clienteService.atualizar(1L, cliente, authorizationHeader)).thenReturn(null);

        ResponseEntity<ClientesEntity> response = clienteController.atualizar(1L, cliente, authorizationHeader);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clienteService).atualizar(1L, cliente, authorizationHeader);
    }

    @Test
    void deveDeletarClienteComSucesso() {
        doNothing().when(clienteService).deletar(1L, authorizationHeader);

        ResponseEntity<Void> response = clienteController.deletar(1L, authorizationHeader);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(clienteService).deletar(1L, authorizationHeader);
    }

    @Test
    void deveBuscarClientePorPessoaIdExistente() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setId(5L);

        when(clienteService.buscarPorPessoaId(2L, authorizationHeader)).thenReturn(Optional.of(cliente));

        ResponseEntity<ClientesEntity> response = clienteController.buscarPorPessoaId(2L, authorizationHeader);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
        verify(clienteService).buscarPorPessoaId(2L, authorizationHeader);
    }

    @Test
    void deveRetornarNotFoundAoBuscarClientePorPessoaIdInexistente() {
        when(clienteService.buscarPorPessoaId(2L, authorizationHeader)).thenReturn(Optional.empty());

        ResponseEntity<ClientesEntity> response = clienteController.buscarPorPessoaId(2L, authorizationHeader);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clienteService).buscarPorPessoaId(2L, authorizationHeader);
    }
}
