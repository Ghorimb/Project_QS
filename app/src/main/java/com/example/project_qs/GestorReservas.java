package com.example.project_qs;

import java.util.ArrayList;

public class GestorReservas {
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static int obterTotalRefeicoesReservadas() {
        return reservas.size();
    }
}
