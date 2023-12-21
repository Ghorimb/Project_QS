package com.example.project_qs;

public class Utilizador {
    private String nome;
    private String numeroIdentificacao;
    private String senha;
    private TipoUtilizador tipoUtilizador;

    public Utilizador(String nome, String numeroIdentificacao, String senha, TipoUtilizador tipoUtilizador) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}

