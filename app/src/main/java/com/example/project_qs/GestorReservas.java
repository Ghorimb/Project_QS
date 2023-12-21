package com.example.project_qs;

import android.icu.util.Calendar;

import java.util.ArrayList;

public class GestorReservas {
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static int obterTotalRefeicoesReservadas() {
        return reservas.size();
    }

    // Método para verificar se é possível realizar uma reserva antecipada até às 11h
    public static boolean podeReservarAntecipadamente() {
        Calendar calendar = Calendar.getInstance();
        int horaAtual = calendar.get(Calendar.HOUR_OF_DAY);

        // Permitir reservas antecipadas até às 11h
        // Você pode ajustar o horário limite conforme necessário
        int horarioLimiteReservas = 19;

        return horaAtual < horarioLimiteReservas;
    }
}
