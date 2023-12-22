package com.example.project_qs;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefeicaoTest {

    private ArrayList<String> modalidades;

    @Before
    public void setUp() {
        // Crie uma lista de modalidades de exemplo para testar
        modalidades = new ArrayList<>();
        modalidades.add("Opção 1");
        modalidades.add("Opção 2");
    }

    @Test
    public void testGetTipo() {
        Refeicao refeicao = new Refeicao("Prato peixe", modalidades);
        assertEquals("Prato peixe", refeicao.getTipo());
    }

    @Test
    public void testSetTipo() {
        Refeicao refeicao = new Refeicao("Prato carne", modalidades);
        refeicao.setTipo("Prato peixe");
        assertEquals("Prato peixe", refeicao.getTipo());
    }

    @Test
    public void testGetModalidades() {
        Refeicao refeicao = new Refeicao("Vegetariano", modalidades);
        assertNotNull(refeicao.getModalidades());
        assertEquals(modalidades, refeicao.getModalidades());
    }

    @Test
    public void testSetModalidades() {
        Refeicao refeicao = new Refeicao("Prato carne", modalidades);

        ArrayList<String> novasModalidades = new ArrayList<>();
        novasModalidades.add("Opção 3");
        novasModalidades.add("Opção 4");

        refeicao.setModalidades(novasModalidades);

        assertNotNull(refeicao.getModalidades());
        assertEquals(novasModalidades, refeicao.getModalidades());
    }
}

