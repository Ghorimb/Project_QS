package com.example.project_qs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SessionManagerTest {

    private Utilizador utilizador;

    @Before
    public void setUp() {
        // Crie um Utilizador de exemplo para testar
        utilizador = new Utilizador("João", "123456", "senha123", TipoUtilizador.FUNCIONARIO);
    }

    @Test
    public void testSetGetUtilizadorAutenticado() {
        // Verifique se o utilizador autenticado é inicialmente nulo
        assertNull(SessionManager.getUtilizadorAutenticado());

        // Defina um utilizador autenticado
        SessionManager.setUtilizadorAutenticado(utilizador);

        // Verifique se a recuperação do utilizador autenticado é correta
        assertEquals(utilizador, SessionManager.getUtilizadorAutenticado());

        // Limpe o utilizador autenticado
        SessionManager.setUtilizadorAutenticado(null);

        // Verifique se o utilizador autenticado é nulo após limpar
        assertNull(SessionManager.getUtilizadorAutenticado());
    }
}

