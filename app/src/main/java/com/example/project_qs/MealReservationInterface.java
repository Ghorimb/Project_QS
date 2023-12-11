package com.example.project_qs;
public interface MealReservationInterface {

    void makeReservation(User user, MealOrder mealOrder);

    void updateReservation(MealTicket mealTicket, MealOrder updatedOrder);

    void cancelReservation(MealTicket mealTicket);

    // Adicione métodos adicionais conforme necessário, por exemplo, para relatórios e estatísticas
}

