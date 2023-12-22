package com.example.project_qs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FuncionarioActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        textViewInfo = findViewById(R.id.textViewInfo);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Exemplo de como um funcionário pode visualizar informações
        int totalRefeicoesReservadas = GestorReservas.obterTotalRefeicoesReservadas(); // Supondo que você tenha um método assim

        String mensagemInfo = "Total de refeições reservadas: " + totalRefeicoesReservadas;
        textViewInfo.setText(mensagemInfo);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementar a lógica de logout aqui, por exemplo, limpar a sessão, redefinir dados, etc.

                // Voltar para a LoginActivity
                Intent intent = new Intent(FuncionarioActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Fecha a FuncionarioActivity para que o utilizador não possa voltar a ela pressionando o botão "Voltar"
            }
        });
    }
}

