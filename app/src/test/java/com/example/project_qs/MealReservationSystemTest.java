package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MealReservationSystemTest {

    @Test
    public void testCreateReservation() {
        MealReservationSystem reservationSystem = new MealReservationSystem();
        User user = new User("John Doe", "123456", UserType.USER, "john", "password");
        MealType mealType = new MealType("Vegetarian", "Vegetarian Meal");
        MealOrder mealOrder = new MealOrder(mealType, 2);

        reservationSystem.createReservation(user, mealOrder);

        // Asserts para verificar se a reserva foi criada corretamente
        assertEquals(1, reservationSystem.getMealTickets().size());
        assertEquals(user, reservationSystem.getMealTickets().get(0).getUser());
        assertEquals(mealOrder, reservationSystem.getMealTickets().get(0).getMealOrder());
    }

    @Test
    public void testCancelReservation() {
        MealReservationSystem reservationSystem = new MealReservationSystem();
        User user = new User("Jane Doe", "789012", UserType.USER, "jane", "password");
        MealType mealType = new MealType("Fish", "Fish Meal");
        MealOrder mealOrder = new MealOrder(mealType, 1);

        reservationSystem.createReservation(user, mealOrder);
        int initialSize = reservationSystem.getMealTickets().size();

        // Cancela a reserva e verifica se o tamanho diminuiu
        reservationSystem.cancelReservation(reservationSystem.getMealTickets().get(0));
        assertEquals(initialSize - 1, reservationSystem.getMealTickets().size());
    }

    // Adicione mais métodos de teste conforme necessário
}

