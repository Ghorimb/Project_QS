package com.example.project_qs;
import java.util.ArrayList;

public class Autenticacao {
    private ArrayList<Utilizador> utilizadores;

    public Autenticacao() {
        this.utilizadores = new ArrayList<>();
        // Adicione alguns utilizadores de exemplo (substitua com a lógica real)
        registarUtilizador("admin1", "admin1", TipoUtilizador.CLIENTE);
        registarUtilizador("admin2", "admin2", TipoUtilizador.FUNCIONARIO);
    }

    public void registarUtilizador(String nome, String numeroIdentificacao, TipoUtilizador tipo) {
        Utilizador utilizador = new Utilizador(nome, numeroIdentificacao, tipo);
        utilizadores.add(utilizador);
    }

    public Utilizador autenticarUtilizador(String nome, String numeroIdentificacao) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getNome().equals(nome) && utilizador.getNumeroIdentificacao().equals(numeroIdentificacao)) {
                return utilizador;
            }
        }
        return null;
    }
}


