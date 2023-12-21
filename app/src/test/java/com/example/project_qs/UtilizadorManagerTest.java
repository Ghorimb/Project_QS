package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class UtilizadorManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testCreateUser() {
        userManager.createUser("john", "password", "John Doe", "123456", TipoUtilizador.USER);
        Utilizador utilizador = userManager.getUserByUsername("john");

        assertNotNull(utilizador);
        assertEquals("John Doe", utilizador.getName());
        assertEquals("123456", utilizador.getIdentificationNumber());
        assertEquals(TipoUtilizador.USER, utilizador.getUserType());
    }

    @Test
    public void testCreateEmployeeAccess() {
        userManager.createUser("jane", "password123", "Jane Doe", "789012", TipoUtilizador.USER);
        userManager.createEmployeeAccess("jane");

        Utilizador utilizador = userManager.getUserByUsername("jane");

        assertNotNull(utilizador);
        assertEquals(TipoUtilizador.EMPLOYEE, utilizador.getUserType());
    }

    // Adicione mais métodos de teste conforme necessário

}

