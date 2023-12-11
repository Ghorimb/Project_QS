package com.example.project_qs;
import java.util.List;

public class MealReporting {

    public void generateReport(List<MealTicket> mealTickets) {
        // Lógica para gerar relatórios com base nos tickets de refeição fornecidos
        for (MealTicket mealTicket : mealTickets) {
            // Processar cada ticket para o relatório
            System.out.println("Relatório: " + mealTicket.getUser().getName() + " - " +
                    mealTicket.getMealOrder().getMealType().getName() + " - " +
                    mealTicket.getReservationTime());
            // Adicione lógica adicional conforme necessário
        }
    }

    // Adicione métodos adicionais conforme necessário
}

