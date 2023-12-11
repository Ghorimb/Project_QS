package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainApplicationTest {

    @Test
    public void testApplicationInitialization() {
        MainApplication application = MainApplication.getInstance();

        // Asserts para verificar se a aplicação foi inicializada corretamente
        assertNotNull(application);
        // Adicione mais asserts conforme necessário para a configuração da aplicação
    }

    // Adicione mais métodos de teste conforme necessário para a configuração da aplicação
}

