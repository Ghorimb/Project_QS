package com.example.project_qs;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // Inicializar qualquer configuração global aqui, se necessário
    }

    public static MainApplication getInstance() {
        return instance;
    }
}

