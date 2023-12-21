package com.example.project_qs;

import java.util.Date;

public class Reserva {
    private String userId;
    private Date dataReserva;
    private Refeicao refeicao;

    public Reserva(String userId, Refeicao refeicao) {
        this.userId = userId;
        this.dataReserva = new Date();
        this.refeicao = refeicao;
    }

    // Getters e setters, se necessário
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }
}

