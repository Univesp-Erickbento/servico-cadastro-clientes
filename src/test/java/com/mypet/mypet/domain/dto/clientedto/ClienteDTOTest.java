package com.mypet.mypet.domain.dto.clientedto;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDTOTest {

    @Test
    void deveCriarClienteDTOComConstrutorPadraoESetters() {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(1L);
        dto.setPessoaId(10L);
        dto.setClienteReg("REG-001");

        assertEquals(1L, dto.getId());
        assertEquals(10L, dto.getPessoaId());
        assertEquals("REG-001", dto.getClienteReg());
    }

    @Test
    void deveCriarClienteDTOComAllArgsConstructor() {
        ClienteDTO dto = new ClienteDTO(1L, 10L, "REG-001");

        assertEquals(1L, dto.getId());
        assertEquals(10L, dto.getPessoaId());
        assertEquals("REG-001", dto.getClienteReg());
    }

    @Test
    void equalsEHashCodeDevemSerBaseadosNosValores() {
        ClienteDTO dto1 = new ClienteDTO(1L, 10L, "REG-001");
        ClienteDTO dto2 = new ClienteDTO(1L, 10L, "REG-001");
        ClienteDTO dto3 = new ClienteDTO(2L, 20L, "REG-002");

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void toStringDeveConterCamposPrincipais() {
        ClienteDTO dto = new ClienteDTO(1L, 10L, "REG-001");
        String texto = dto.toString();

        assertTrue(texto.contains("ClienteDTO"));
        assertTrue(texto.contains("1"));
        assertTrue(texto.contains("10"));
        assertTrue(texto.contains("REG-001"));
    }

    @Test
    void deveSerSerializavel() throws IOException, ClassNotFoundException {
        ClienteDTO original = new ClienteDTO(1L, 10L, "REG-001");

        // Serializar em memória
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(original);

        // Desserializar de volta
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        ClienteDTO desserializado = (ClienteDTO) in.readObject();

        assertEquals(original.getId(), desserializado.getId());
        assertEquals(original.getPessoaId(), desserializado.getPessoaId());
        assertEquals(original.getClienteReg(), desserializado.getClienteReg());
    }
}
