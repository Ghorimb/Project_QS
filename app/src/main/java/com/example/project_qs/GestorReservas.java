package com.example.project_qs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorReservas {

    private static Map<String, Map<String, List<Reserva>>> reservasPorTipoEModalidade = new HashMap<>();
    private static int contadorRefeicoesReservadas = 0;

    public static void adicionarReserva(Reserva reserva) {
        // Obter o tipo de refeição e a modalidade da reserva
        String tipoRefeicao = reserva.getRefeicao().getTipo();
        String modalidade = reserva.getRefeicao().getModalidades().get(0); // Assumindo uma única modalidade

        // Verificar se o tipo de refeição já existe no mapa
        if (!reservasPorTipoEModalidade.containsKey(tipoRefeicao)) {
            // Se não existir, adicionar uma nova entrada para o tipo de refeição
            reservasPorTipoEModalidade.put(tipoRefeicao, new HashMap<>());
        }

        // Obter o mapa de modalidades correspondente ao tipo de refeição
        Map<String, List<Reserva>> reservasPorModalidade = reservasPorTipoEModalidade.get(tipoRefeicao);

        // Verificar se a modalidade já existe no mapa
        if (!reservasPorModalidade.containsKey(modalidade)) {
            // Se não existir, adicionar uma nova entrada para a modalidade
            reservasPorModalidade.put(modalidade, new ArrayList<>());
        }

        // Adicionar a reserva à lista correspondente à modalidade
        reservasPorModalidade.get(modalidade).add(reserva);

        // Atualizar o contador de refeições reservadas
        contadorRefeicoesReservadas++;
    }

    public static String obterDetalhesReservasPorTipoEModalidade(String tipoRefeicao, String modalidade) {
        // Verificar se o tipo de refeição existe no mapa
        if (reservasPorTipoEModalidade.containsKey(tipoRefeicao)) {
            // Obter o mapa de modalidades correspondente ao tipo de refeição
            Map<String, List<Reserva>> reservasPorModalidade = reservasPorTipoEModalidade.get(tipoRefeicao);

            // Verificar se a modalidade existe no mapa
            if (reservasPorModalidade.containsKey(modalidade)) {
                // Obter a lista de reservas correspondente à modalidade
                List<Reserva> reservas = reservasPorModalidade.get(modalidade);

                // Construir uma string com os detalhes das reservas
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
