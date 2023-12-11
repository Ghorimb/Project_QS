package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MealTicketTest {

    @Test
    public void testCreateMealTicket() {
        User user = new User("John Doe", "123456", UserType.USER, "john", "password");
        MealType mealType = new MealType("Vegetarian", "Vegetarian Meal");
        MealOrder mealOrder = new MealOrder(mealType, 2);

        MealTicket mealTicket = new MealTicket(user, mealOrder);

        // Asserts para verificar se o ticket de refeição foi criado corretamente
        assertEquals(user, mealTicket.getUser());
        assertEquals(mealOrder, mealTicket.getMealOrder());
        assertNotNull(mealTicket.getQrCode());
        assertNotNull(mealTicket.getReservationTime());
    }

    // Adicione mais métodos de teste conforme necessário
}

