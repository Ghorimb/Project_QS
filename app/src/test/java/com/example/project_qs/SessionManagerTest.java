package com.example.project_qs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SessionManagerTest {

    private Utilizador utilizador;

    @Before
    public void setUp() {
        utilizador = new Utilizador("João", "123456", "senha123", TipoUtilizador.FUNCIONARIO);
    }

    @Test
    public void testSetGetUtilizadorAutenticado() {
        assertNull(SessionManager.getUtilizadorAutenticado());

        SessionManager.setUtilizadorAutenticado(utilizador);

        assertEquals(utilizador, SessionManager.getUtilizadorAutenticado());

        SessionManager.setUtilizadorAutenticado(null);

        assertNull(SessionManager.getUtilizadorAutenticado());
    }
}

