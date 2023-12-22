package com.example.project_qs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilizadorTest {

    private Utilizador utilizador;

    @Before
    public void setUp() {
        utilizador = new Utilizador("João", "123456", "senha123", TipoUtilizador.FUNCIONARIO);
    }

    @Test
    public void testGetNome() {
        assertEquals("João", utilizador.getNome());
    }

    @Test
    public void testSetNome() {
        utilizador.setNome("Maria");
        assertEquals("Maria", utilizador.getNome());
    }

    @Test
    public void testGetNumeroIdentificacao() {
        assertEquals("123456", utilizador.getNumeroIdentificacao());
    }

    @Test
    public void testSetNumeroIdentificacao() {
        utilizador.setNumeroIdentificacao("654321");
        assertEquals("654321", utilizador.getNumeroIdentificacao());
    }

    @Test
    public void testGetPassword() {
        assertEquals("senha123", utilizador.getPassword());
    }

    @Test
    public void testSetPassword() {
        utilizador.setPassword("novaSenha456");
        assertEquals("novaSenha456", utilizador.getPassword());
    }

    @Test
    public void testGetTipoUtilizador() {
        assertEquals(TipoUtilizador.FUNCIONARIO, utilizador.getTipoUtilizador());
    }

}

