package com.example.project_qs;
import java.util.Date;

public class MealAvailabilityChecker {

    public boolean isMealAvailable(Date currentTime) {
        // Lógica para verificar a disponibilidade de refeições
        // Neste exemplo, assume-se que as reservas são aceitas até às 11h no mesmo dia
        Date limitTime = getReservationLimitTime();
        return currentTime.before(limitTime);
    }

    private Date getReservationLimitTime() {
        // Lógica para obter o limite de tempo para reservas (por exemplo, 11h no mesmo dia)
        // Substitua com uma implementação real
        // Neste exemplo, adiciona-se 11 horas ao momento atual
        long currentTimeMillis = System.currentTimeMillis();
        return new Date(currentTimeMillis + 11 * 60 * 60 * 1000);
    }

    // Adicione métodos adicionais conforme necessário
}

