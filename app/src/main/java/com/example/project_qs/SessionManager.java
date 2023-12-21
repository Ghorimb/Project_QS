package com.example.project_qs;

public class SessionManager {
    private static Utilizador utilizadorAutenticado;

    public static void setUtilizadorAutenticado(Utilizador utilizador) {
        utilizadorAutenticado = utilizador;
    }

    public static Utilizador getUtilizadorAutenticado() {
        return utilizadorAutenticado;
    }
}
