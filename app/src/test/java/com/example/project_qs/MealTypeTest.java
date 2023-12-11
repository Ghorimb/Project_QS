package com.example.project_qs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MealTypeTest {

    @Test
    public void testCreateMealType() {
        MealType mealType = new MealType("Vegetarian", "Vegetarian Meal");

        // Asserts para verificar se o tipo de refeição foi criado corretamente
        assertEquals("Vegetarian", mealType.getName());
        assertEquals("Vegetarian Meal", mealType.getDescription());
    }

    // Adicione mais métodos de teste conforme necessário
}

