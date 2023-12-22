package com.example.project_qs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ClienteActivity extends AppCompatActivity {

    private Button buttonReservar;
    private Button buttonLogout;
    private TextView textViewMensagem;
    private Utilizador utilizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        // Obter informações do utilizador autenticado
        utilizador = Autenticacao.autenticarUtilizadorAtual();

        buttonReservar = findViewById(R.id.buttonReservar);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewMensagem = findViewById(R.id.textViewMensagem);

        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GestorReservas.podeReservarAntecipadamente()) {
                    // Supondo que você já tenha uma instância de Refeicao
                    Refeicao refeicao = new Refeicao("Prato", new ArrayList<>(Arrays.asList("Sopa", "Prato", "Sobremesa")));

                    // Criar uma nova reserva
                    Reserva reserva = new Reserva(utilizador, refeicao);
                    GestorReservas.adicionarReserva(reserva);

                    // Exemplo de como utilizar os dados da reserva
                    String mensagem = "Reserva realizada! Detalhes: \n" +
                            "Usuário ID: " + reserva.getUtilizador().getNumeroIdentificacao() + "\n" +
                            "Data da Reserva: " + reserva.getDataReserva() + "\n" +
                            "Tipo de Refeição: " + reserva.getRefeicao().getTipo() + "\n" +
                            "Modalidades: " + reserva.getRefeicao().getModalidades();

                    // Atualizar a TextView com a mensagem
                    textViewMensagem.setText(mensagem);
                } else {
                    // Atualizar a TextView com a mensagem
                    textViewMensagem.setText("Não é possível reservar antecipadamente neste momento.");
                }
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implementar a lógica de logout aqui, por exemplo, limpar a sessão, redefinir dados, etc.

                // Voltar para a LoginActivity
                Intent intent = new Intent(ClienteActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Fecha a ClienteActivity para que o utilizador não possa voltar a ela pressionando o botão "Voltar"
            }
        });
    }
}

