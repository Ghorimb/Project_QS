package com.example.project_qs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FuncionarioActivity extends AppCompatActivity {

    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        textViewInfo = findViewById(R.id.textViewInfo);

        // Exemplo de como um funcionário pode visualizar informações
        int totalRefeicoesReservadas = GestorReservas.obterTotalRefeicoesReservadas(); // Supondo que você tenha um método assim

        String mensagemInfo = "Total de refeições reservadas: " + totalRefeicoesReservadas;
        textViewInfo.setText(mensagemInfo);
    }
}

