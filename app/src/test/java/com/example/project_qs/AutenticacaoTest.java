package com.example.project_qs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AutenticacaoTest {

    private Autenticacao autenticacao;

    @Before
    public void setUp() {
        autenticacao = new Autenticacao();
    }

    @Test
    public void testRegistarUtilizador() {
        autenticacao.registarUtilizador("Novo Utilizador", "12345", "senha123", TipoUtilizador.CLIENTE);

        assertNotNull(autenticacao.autenticarUtilizador("12345", "senha123"));
    }

    @Test
    public void testAutenticarUtilizador() {
        Utilizador utilizadorAutenticado = autenticacao.autenticarUtilizador("41807", "41807");
        assertNotNull(utilizadorAutenticado);
        assertEquals("Maria Pacheco", utilizadorAutenticado.getNome());

        Utilizador utilizadorNaoAutenticado = autenticacao.autenticarUtilizador("123", "senha_errada");
        assertNull(utilizadorNaoAutenticado);
    }

    @Test
    public void testAutenticarUtilizadorAtual() {
        SessionManager.setUtilizadorAutenticado(new Utilizador("Utilizador Autenticado", "123", "senha", TipoUtilizador.CLIENTE));

        assertEquals("Utilizador Autenticado", autenticacao.autenticarUtilizadorAtual().getNome());
    }
}

