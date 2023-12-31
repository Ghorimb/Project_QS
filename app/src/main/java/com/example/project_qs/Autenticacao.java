package com.example.project_qs;
import java.util.ArrayList;

public class Autenticacao {
    private ArrayList<Utilizador> utilizadores;

    public Autenticacao() {
        this.utilizadores = new ArrayList<>();
        registarUtilizador("Maria Pacheco", "41807", "41807", TipoUtilizador.CLIENTE);
        registarUtilizador("Tiago Sá", "41367", "41367", TipoUtilizador.CLIENTE);
        registarUtilizador("Bruno Amorim", "44098", "44098", TipoUtilizador.CLIENTE);
        registarUtilizador("João Alves", "44687", "44687", TipoUtilizador.FUNCIONARIO);
    }

    public void registarUtilizador(String nome, String numeroIdentificacao, String password, TipoUtilizador tipoUtilizador) {
        Utilizador utilizador = new Utilizador(nome, numeroIdentificacao, password, tipoUtilizador);
        utilizadores.add(utilizador);
    }

    public Utilizador autenticarUtilizador(String numeroIdentificacao, String password) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getNumeroIdentificacao().equals(numeroIdentificacao) && utilizador.getPassword().equals(password)) {
                return utilizador;
            }
        }
        return null;
    }

    public static Utilizador autenticarUtilizadorAtual() {
        return SessionManager.getUtilizadorAutenticado();
    }
}
