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

        // Verificar se o utilizador foi registado corretamente
        assertNotNull(autenticacao.autenticarUtilizador("12345", "senha123"));
    }

    @Test
    public void testAutenticarUtilizador() {
        // Verificar autenticação com credenciais corretas
        Utilizador utilizadorAutenticado = autenticacao.autenticarUtilizador("41807", "41807");
        assertNotNull(utilizadorAutenticado);
        assertEquals("Maria Pacheco", utilizadorAutenticado.getNome());

        // Verificar autenticação com credenciais incorretas
        Utilizador utilizadorNaoAutenticado = autenticacao.autenticarUtilizador("123", "senha_errada");
        assertNull(utilizadorNaoAutenticado);
    }

    @Test
    public void testAutenticarUtilizadorAtual() {
        // Como a implementação de autenticarUtilizadorAtual depende de SessionManager,
        // você pode precisar configurar o estado do SessionManager para este teste

        // Neste exemplo, configuramos um utilizador autenticado no SessionManager
        SessionManager.setUtilizadorAutenticado(new Utilizador("Utilizador Autenticado", "123", "senha", TipoUtilizador.CLIENTE));

        // Verificar se o utilizador obtido através do autenticarUtilizadorAtual é o mesmo que configuramos
        assertEquals("Utilizador Autenticado", autenticacao.autenticarUtilizadorAtual().getNome());
    }
}

