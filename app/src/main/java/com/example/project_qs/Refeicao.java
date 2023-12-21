package com.example.project_qs;

import java.util.ArrayList;

public class Refeicao {
    private String tipo;
    private ArrayList<String> modalidades;

    public Refeicao(String tipo, ArrayList<String> modalidades) {
        this.tipo = tipo;
        this.modalidades = modalidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(ArrayList<String> modalidades) {
        this.modalidades = modalidades;
    }
}

