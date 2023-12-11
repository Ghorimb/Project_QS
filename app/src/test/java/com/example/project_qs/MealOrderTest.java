package com.example.project_qs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MealOrderTest {

    @Test
    public void testCreateMealOrder() {
        MealType mealType = new MealType("Vegetarian", "Vegetarian Meal");
        MealOrder mealOrder = new MealOrder(mealType, 2);

        // Asserts para verificar se o pedido de refeição foi criado corretamente
        assertEquals(mealType, mealOrder.getMealType());
        assertEquals(2, mealOrder.getQuantity());
    }

    // Adicione mais métodos de teste conforme necessário
}

