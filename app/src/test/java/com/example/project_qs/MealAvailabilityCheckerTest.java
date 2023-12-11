package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class MealAvailabilityCheckerTest {

    @Test
    public void testIsMealAvailable() {
        MealAvailabilityChecker availabilityChecker = new MealAvailabilityChecker();

        // Assume que a hora atual é antes das 11h para aceitar reservas
        assertTrue(availabilityChecker.isMealAvailable(new Date()));

        // Simula uma hora após as 11h para verificar que as reservas não são mais aceitas
        Date afterElevenAM = new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000);
        assertFalse(availabilityChecker.isMealAvailable(afterElevenAM));
    }

    // Adicione mais métodos de teste conforme necessário
}

