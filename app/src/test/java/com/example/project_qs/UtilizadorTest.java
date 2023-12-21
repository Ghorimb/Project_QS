package com.example.project_qs;
import org.junit.jupiter.api.Test;

public class UtilizadorTest {

    @Test
    public void testCreateUser() {
        Utilizador utilizador = new Utilizador("John Doe", "123456", TipoUtilizador.USER, "john", "password");

        // Asserts para verificar se o usuário foi criado corretamente
        assertEquals("John Doe", utilizador.getName());
        assertEquals("123456", utilizador.getIdentificationNumber());
        assertEquals(TipoUtilizador.USER, utilizador.getUserType());
        assertEquals("john", utilizador.getUsername());
        assertEquals("password", utilizador.getPassword());
    }

    // Adicione mais métodos de teste conforme necessário
}

