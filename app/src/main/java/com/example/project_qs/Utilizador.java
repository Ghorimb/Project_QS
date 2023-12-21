package com.example.project_qs;

public class Utilizador {
    private String nome;
    private String numeroIdentificacao;
    private TipoUtilizador tipo;

    public Utilizador(String nome, String numeroIdentificacao, TipoUtilizador tipo) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public TipoUtilizador getTipo() {
        return tipo;
    }
}

