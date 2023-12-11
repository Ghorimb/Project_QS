package com.example.project_qs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MealReportingTest {

    @Test
    public void testGenerateReport() {
        MealReporting mealReporting = new MealReporting();

        User user = new User("John Doe", "123456", UserType.USER, "john", "password");
        MealType mealType = new MealType("Vegetarian", "Vegetarian Meal");
        MealOrder mealOrder = new MealOrder(mealType, 2);
        MealTicket mealTicket = new MealTicket(user, mealOrder);

        List<MealTicket> mealTickets = new ArrayList<>();
        mealTickets.add(mealTicket);

        // Asserts para verificar se o relatório é gerado corretamente
        mealReporting.generateReport(mealTickets);
        // Adicione mais asserts conforme necessário
    }

    // Adicione mais métodos de teste conforme necessário
}

