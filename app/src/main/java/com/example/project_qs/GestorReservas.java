package com.example.project_qs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorReservas {

    private static Map<String, Map<String, List<Reserva>>> reservasPorTipoEModalidade = new HashMap<>();
    private static int contadorRefeicoesReservadas = 0;

    public static void adicionarReserva(Reserva reserva) {
        String tipoRefeicao = reserva.getRefeicao().getTipo();
        String modalidade = reserva.getRefeicao().getModalidades().get(0); // Assumindo uma única modalidade

        if (!reservasPorTipoEModalidade.containsKey(tipoRefeicao)) {
            reservasPorTipoEModalidade.put(tipoRefeicao, new HashMap<>());
        }

        Map<String, List<Reserva>> reservasPorModalidade = reservasPorTipoEModalidade.get(tipoRefeicao);

        if (!reservasPorModalidade.containsKey(modalidade)) {
            reservasPorModalidade.put(modalidade, new ArrayList<>());
        }

        reservasPorModalidade.get(modalidade).add(reserva);

        contadorRefeicoesReservadas++;
    }

    public static String obterDetalhesReservasPorTipoEModalidade(String tipoRefeicao, String modalidade) {
        if (reservasPorTipoEModalidade.containsKey(tipoRefeicao)) {
            Map<String, List<Reserva>> reservasPorModalidade = reservasPorTipoEModalidade.get(tipoRefeicao);

            if (reservasPorModalidade.containsKey(modalidade)) {
                List<Reserva> reservas = reservasPorModalidade.get(modalidade);

                StringBuilder detalhes = new StringBuilder();
                for (Reserva reserva : reservas) {
                    detalhes.append("Utilizador: ").append(reserva.getUtilizador().getNome()).append("\n");
                    detalhes.append("Data da Reserva: ").append(reserva.getDataReserva()).append("\n");
                    detalhes.append("Tipo de Refeição: ").append(reserva.getRefeicao().getTipo()).append("\n");
                    detalhes.append("Modalidade: ").append(reserva.getRefeicao().getModalidades().get(0)).append("\n\n");
                }

                return detalhes.toString();
            }
        }

        return "Não há reservas para o tipo de refeição e modalidade selecionados.";
    }

    public static int getContadorRefeicoesReservadas() {
        return contadorRefeicoesReservadas;
    }
}
