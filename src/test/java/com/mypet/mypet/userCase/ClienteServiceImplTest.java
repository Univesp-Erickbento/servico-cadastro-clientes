package com.mypet.mypet.userCase;

import com.mypet.mypet.adapters.out.repositories.ClienteRepository;
import com.mypet.mypet.application.core.domain.model.ClientesEntity;
import com.mypet.mypet.domain.dto.clientedto.ClienteEnvioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private String authorizationHeader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorizationHeader = "Bearer token_teste";
    }

    @Test
    void deveSalvarClienteComSucesso() {
        ClienteEnvioDTO dto = new ClienteEnvioDTO(
                "João",
                "Silva",
                "12345678900",
                "MG12345",
                "MASCULINO",
                "USER",
                "joao@email.com",
                "11999999999",
                LocalDate.of(1990, 1, 1),
                123L,
                "REG-001",
                "ATIVO"
        );

        ClientesEntity salvo = new ClientesEntity();
        salvo.setId(1L);
        salvo.setPessoaId(dto.pessoaId());
        salvo.setClienteReg(dto.clienteReg());
        salvo.setClienteStatus(dto.clienteStatus());

        when(clienteRepository.save(any(ClientesEntity.class))).thenReturn(salvo);

        ClientesEntity resultado = clienteService.salvar(dto, authorizationHeader);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals(123L, resultado.getPessoaId());
        assertEquals("REG-001", resultado.getClienteReg());
        assertEquals("ATIVO", resultado.getClienteStatus());

        verify(clienteRepository, times(1)).save(any(ClientesEntity.class));
    }

    @Test
    void deveAtualizarClienteComSucesso() {
        ClientesEntity existente = new ClientesEntity();
        existente.setId(1L);
        existente.setPessoaId(100L);
        existente.setClienteReg("OLD-REG");
        existente.setClienteStatus("INATIVO");

        ClientesEntity atualizado = new ClientesEntity();
        atualizado.setPessoaId(200L);
        atualizado.setClienteReg("NEW-REG");
        atualizado.setClienteStatus("ATIVO");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(clienteRepository.save(any(ClientesEntity.class))).thenReturn(existente);

        ClientesEntity resultado = clienteService.atualizar(1L, atualizado, authorizationHeader);

        assertNotNull(resultado);
        assertEquals(200L, resultado.getPessoaId());
        assertEquals("NEW-REG", resultado.getClienteReg());
        assertEquals("ATIVO", resultado.getClienteStatus());

        verify(clienteRepository).findById(1L);
        verify(clienteRepository).save(any(ClientesEntity.class));
    }

    @Test
    void deveRetornarNullAoTentarAtualizarClienteInexistente() {
        ClientesEntity atualizado = new ClientesEntity();
        atualizado.setPessoaId(200L);

        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        ClientesEntity resultado = clienteService.atualizar(99L, atualizado, authorizationHeader);

        assertNull(resultado);
        verify(clienteRepository, never()).save(any());
    }

    @Test
    void deveListarTodosClientes() {
        ClientesEntity c1 = new ClientesEntity();
        ClientesEntity c2 = new ClientesEntity();

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<ClientesEntity> lista = clienteService.listarTodos(authorizationHeader);

        assertEquals(2, lista.size());
        verify(clienteRepository).findAll();
    }

    @Test
    void deveBuscarClientePorId() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<ClientesEntity> resultado = clienteService.buscarPorId(1L, authorizationHeader);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        verify(clienteRepository).findById(1L);
    }

    @Test
    void deveDeletarClientePorId() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deletar(1L, authorizationHeader);

        verify(clienteRepository).deleteById(1L);
    }

    @Test
    void deveBuscarClientePorPessoaId() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setPessoaId(123L);

        when(clienteRepository.findByPessoaId(123L)).thenReturn(Optional.of(cliente));

        Optional<ClientesEntity> resultado = clienteService.buscarPorPessoaId(123L, authorizationHeader);

        assertTrue(resultado.isPresent());
        assertEquals(123L, resultado.get().getPessoaId());
        verify(clienteRepository).findByPessoaId(123L);
    }
}
