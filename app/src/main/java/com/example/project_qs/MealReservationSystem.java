package com.example.project_qs;

import java.util.ArrayList;
import java.util.List;

public class MealReservationSystem {

    private List<MealTicket> mealTickets;

    public MealReservationSystem() {
        this.mealTickets = new ArrayList<>();
    }

    public void createReservation(User user, MealOrder mealOrder) {
        // Lógica para criar uma reserva
        MealTicket mealTicket = new MealTicket(user, mealOrder);
        mealTickets.add(mealTicket);
    }

    public void updateReservation(MealTicket mealTicket, MealOrder updatedOrder) {
        // Lógica para atualizar uma reserva
        mealTicket.setMealOrder(updatedOrder);
    }

    public void cancelReservation(MealTicket mealTicket) {
        // Lógica para cancelar uma reserva
        mealTickets.remove(mealTicket);
    }

    public List<MealTicket> getMealTickets() {
        return mealTickets;
    }

    // Adicione métodos adicionais conforme necessário para relatórios e estatísticas
}

