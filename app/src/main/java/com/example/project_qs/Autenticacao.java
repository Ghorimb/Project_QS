package com.example.project_qs;
import java.util.ArrayList;

public class Autenticacao {
    private ArrayList<Utilizador> utilizadores;

    public Autenticacao() {
        this.utilizadores = new ArrayList<>();
        // Adicione alguns utilizadores de exemplo (substitua com a lógica real)
        registarUtilizador("Maria Pacheco", "41807", "41807", TipoUtilizador.CLIENTE);
        registarUtilizador("João Alves", "44687", "44687", TipoUtilizador.FUNCIONARIO);
    }

    public void registarUtilizador(String nome, String numeroIdentificacao, String senha, TipoUtilizador tipo) {
        Utilizador utilizador = new Utilizador(nome, numeroIdentificacao, senha, tipo);
        utilizadores.add(utilizador);
    }

    public Utilizador autenticarUtilizador(String numeroIdentificacao, String senha) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getNumeroIdentificacao().equals(numeroIdentificacao) && utilizador.getSenha().equals(senha)) {
                return utilizador;
            }
        }
        return null;
    }

    public static Utilizador autenticarUtilizadorAtual() {
        // Lógica para obter o utilizador autenticado atualmente (pode variar dependendo da implementação)
        // Neste exemplo, supomos que o utilizador autenticado é mantido por meio de um controle de sessão (SessionManager)
        return SessionManager.getUtilizadorAutenticado();
    }
}
