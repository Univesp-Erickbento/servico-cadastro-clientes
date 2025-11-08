package com.mypet.mypet.domain.dto.clientedto;

import org.junit.jupiter.api.Test;

import java.io.*;
        import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEnvioDTOTest {

    @Test
    void deveCriarClienteEnvioDTOComValoresCorretos() {
        LocalDate dataNascimento = LocalDate.of(1990, 5, 10);
        ClienteEnvioDTO dto = new ClienteEnvioDTO(
                "João",
                "Silva",
                "12345678900",
                "MG1234567",
                "Masculino",
                "CLIENTE",
                "joao@email.com",
                "31999999999",
                dataNascimento,
                1L,
                "REG-001",
                "ATIVO"
        );

        assertEquals("João", dto.nome());
        assertEquals("Silva", dto.sobrenome());
        assertEquals("12345678900", dto.cpf());
        assertEquals("MG1234567", dto.rg());
        assertEquals("Masculino", dto.genero());
        assertEquals("CLIENTE", dto.perfis());
        assertEquals("joao@email.com", dto.email());
        assertEquals("31999999999", dto.contato());
        assertEquals(dataNascimento, dto.dataNascimento());
        assertEquals(1L, dto.pessoaId());
        assertEquals("REG-001", dto.clienteReg());
        assertEquals("ATIVO", dto.clienteStatus());
    }

    @Test
    void equalsEHashCodeDevemSerBaseadosNosValores() {
        LocalDate data = LocalDate.of(2000, 1, 1);

        ClienteEnvioDTO dto1 = new ClienteEnvioDTO("A", "B", "1", "RG", "M", "CLIENTE", "a@b.com", "123", data, 1L, "REG", "ATIVO");
        ClienteEnvioDTO dto2 = new ClienteEnvioDTO("A", "B", "1", "RG", "M", "CLIENTE", "a@b.com", "123", data, 1L, "REG", "ATIVO");
        ClienteEnvioDTO dto3 = new ClienteEnvioDTO("X", "Y", "9", "RG9", "F", "ADMIN", "x@y.com", "999", data, 2L, "REG2", "INATIVO");

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void toStringDeveConterCamposPrincipais() {
        ClienteEnvioDTO dto = new ClienteEnvioDTO(
                "Maria",
                "Oliveira",
                "98765432100",
                "SP7654321",
                "Feminino",
                "CLIENTE",
                "maria@email.com",
                "11999999999",
                LocalDate.of(1985, 8, 20),
                2L,
                "REG-002",
                "ATIVO"
        );

        String texto = dto.toString();
        assertTrue(texto.contains("Maria"));
        assertTrue(texto.contains("Oliveira"));
        assertTrue(texto.contains("98765432100"));
        assertTrue(texto.contains("REG-002"));
        assertTrue(texto.contains("ATIVO"));
    }
}
