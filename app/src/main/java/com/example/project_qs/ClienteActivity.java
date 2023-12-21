package com.example.project_qs;

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
    private Utilizador utilizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        buttonReservar = findViewById(R.id.buttonReservar);

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

                    Toast.makeText(ClienteActivity.this, mensagem, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ClienteActivity.this, "Não é possível reservar antecipadamente neste momento.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
