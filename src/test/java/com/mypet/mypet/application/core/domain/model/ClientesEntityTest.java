package com.mypet.mypet.application.core.domain.model;

import org.junit.jupiter.api.Test;

import java.io.*;
        import static org.junit.jupiter.api.Assertions.*;

class ClientesEntityTest {

    @Test
    void deveCriarClienteComConstrutorPadraoESetters() {
        ClientesEntity cliente = new ClientesEntity();

        cliente.setId(1L);
        cliente.setPessoaId(123L);
        cliente.setClienteReg("REG-001");
        cliente.setClienteStatus("ATIVO");

        assertEquals(1L, cliente.getId());
        assertEquals(123L, cliente.getPessoaId());
        assertEquals("REG-001", cliente.getClienteReg());
        assertEquals("ATIVO", cliente.getClienteStatus());
    }

    @Test
    void deveCriarClienteComAllArgsConstructor() {
        ClientesEntity cliente = new ClientesEntity(1L, 123L, "REG-001", "ATIVO");

        assertEquals(1L, cliente.getId());
        assertEquals(123L, cliente.getPessoaId());
        assertEquals("REG-001", cliente.getClienteReg());
        assertEquals("ATIVO", cliente.getClienteStatus());
    }

    @Test
    void equalsDeveRetornarVerdadeiroParaMesmoId() {
        ClientesEntity c1 = new ClientesEntity(1L, 123L, "REG-001", "ATIVO");
        ClientesEntity c2 = new ClientesEntity(1L, 999L, "OUTRO", "INATIVO");

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void equalsDeveRetornarFalsoParaIdsDiferentes() {
        ClientesEntity c1 = new ClientesEntity(1L, 123L, "REG-001", "ATIVO");
        ClientesEntity c2 = new ClientesEntity(2L, 123L, "REG-001", "ATIVO");

        assertNotEquals(c1, c2);
    }

    @Test
    void deveSerSerializavel() throws IOException, ClassNotFoundException {
        ClientesEntity original = new ClientesEntity(1L, 123L, "REG-001", "ATIVO");

        // Serializar em memória
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(original);

        // Desserializar de volta
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        ClientesEntity desserializado = (ClientesEntity) in.readObject();

        assertEquals(original.getId(), desserializado.getId());
        assertEquals(original.getPessoaId(), desserializado.getPessoaId());
        assertEquals(original.getClienteReg(), desserializado.getClienteReg());
        assertEquals(original.getClienteStatus(), desserializado.getClienteStatus());
    }

    @Test
    void toStringDeveConterCamposPrincipais() {
        ClientesEntity cliente = new ClientesEntity(1L, 123L, "REG-001", "ATIVO");
        String texto = cliente.toString();

        assertNotNull(texto);
        assertTrue(texto.contains("ClientesEntity"));
        assertTrue(texto.contains("1"));
        assertTrue(texto.contains("123"));
        assertTrue(texto.contains("REG-001"));
        assertTrue(texto.contains("ATIVO"));
    }

}
