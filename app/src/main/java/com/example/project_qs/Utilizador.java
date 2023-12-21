package com.example.project_qs;

public class Utilizador {
    private String nome;
    private String numeroIdentificacao;
    private String password;
    private TipoUtilizador tipoUtilizador;

    public Utilizador(String nome, String numeroIdentificacao, String password, TipoUtilizador tipoUtilizador) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.password = password;
        this.tipoUtilizador = tipoUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}

