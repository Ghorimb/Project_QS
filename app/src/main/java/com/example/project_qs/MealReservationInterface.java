package com.example.project_qs;
public interface MealReservationInterface {

    void makeReservation(Utilizador utilizador, MealOrder mealOrder);

    void updateReservation(MealTicket mealTicket, MealOrder updatedOrder);

    void cancelReservation(MealTicket mealTicket);

    // Adicione métodos adicionais conforme necessário, por exemplo, para relatórios e estatísticas
}

