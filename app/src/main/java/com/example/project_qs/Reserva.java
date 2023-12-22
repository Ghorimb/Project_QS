package com.example.project_qs;

import java.util.Date;

public class Reserva {
    private Utilizador utilizador;
    private Date dataReserva;
    private Refeicao refeicao;

    public Reserva(Utilizador utilizador, Refeicao refeicao) {
        this.utilizador = utilizador;
        this.dataReserva = new Date();
        this.refeicao = refeicao;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }
}
