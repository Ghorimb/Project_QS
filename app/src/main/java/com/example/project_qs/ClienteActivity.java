package com.example.project_qs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;


import java.util.*;

public class ClienteActivity extends AppCompatActivity {

    private Spinner spinnerTiposRefeicao;
    private Spinner spinnerModalidades;

    private Button buttonReservar;
    private Button buttonLogout;
    private TextView textViewMensagem;
    private Utilizador utilizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        utilizador = Autenticacao.autenticarUtilizadorAtual();

        spinnerTiposRefeicao = findViewById(R.id.spinnerTiposRefeicao);
        spinnerModalidades = findViewById(R.id.spinnerModalidades);
        buttonReservar = findViewById(R.id.buttonReservar);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewMensagem = findViewById(R.id.textViewMensagem);

        ArrayAdapter<CharSequence> tiposRefeicaoAdapter = ArrayAdapter.createFromResource(
                this, R.array.tipos_refeicao_array, android.R.layout.simple_spinner_item);
        tiposRefeicaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposRefeicao.setAdapter(tiposRefeicaoAdapter);

        spinnerTiposRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                atualizarSpinnerModalidades(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipoRefeicao = spinnerTiposRefeicao.getSelectedItem().toString();
                String modalidade = spinnerModalidades.getSelectedItem().toString();

                Refeicao refeicao = new Refeicao(tipoRefeicao, new ArrayList<>(Arrays.asList(modalidade)));

                Reserva reserva = new Reserva(utilizador, refeicao);
                GestorReservas.adicionarReserva(reserva);

                String mensagem = "Reserva realizada! Detalhes: \n" +
                        "Utilizador: " + reserva.getUtilizador().getNome() + "\n" +
                        "Data da Reserva: " + reserva.getDataReserva() + "\n" +
                        "Tipo de Refeição: " + reserva.getRefeicao().getTipo() + "\n" +
                        "Modalidades: " + reserva.getRefeicao().getModalidades();

                textViewMensagem.setText(mensagem);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClienteActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Fecha a ClienteActivity para que o utilizador não possa voltar a ela pressionando o botão "Voltar"
            }
        });
    }

    private void atualizarSpinnerModalidades(int tipoRefeicaoPosition) {
        String[] modalidadesArray;
        switch (tipoRefeicaoPosition) {
            case 0:
                modalidadesArray = getResources().getStringArray(R.array.modalidades_prato_peixe_array);
                break;
            case 1:
                modalidadesArray = getResources().getStringArray(R.array.modalidades_prato_carne_array);
                break;
            case 2:
                modalidadesArray = getResources().getStringArray(R.array.modalidades_vegetariano_array);
                break;
            default:
                modalidadesArray = new String[0];
        }

        ArrayAdapter<String> modalidadesAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, modalidadesArray);
        modalidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModalidades.setAdapter(modalidadesAdapter);
    }
}
