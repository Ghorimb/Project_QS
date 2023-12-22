package com.example.project_qs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TipoUtilizadorTest {

    @Test
    public void testEnumValues() {
        assertEquals("CLIENTE", TipoUtilizador.CLIENTE.name());
        assertEquals("FUNCIONARIO", TipoUtilizador.FUNCIONARIO.name());
    }

    @Test
    public void testEnumOrdinal() {
        assertEquals(0, TipoUtilizador.CLIENTE.ordinal());
        assertEquals(1, TipoUtilizador.FUNCIONARIO.ordinal());
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(TipoUtilizador.CLIENTE, TipoUtilizador.valueOf("CLIENTE"));
        assertEquals(TipoUtilizador.FUNCIONARIO, TipoUtilizador.valueOf("FUNCIONARIO"));
    }

    @Test
    public void testEnumValuesArray() {
        TipoUtilizador[] values = TipoUtilizador.values();
        assertEquals(2, values.length);
        assertEquals(TipoUtilizador.CLIENTE, values[0]);
        assertEquals(TipoUtilizador.FUNCIONARIO, values[1]);
    }
}

