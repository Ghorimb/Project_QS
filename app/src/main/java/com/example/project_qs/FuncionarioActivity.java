package com.example.project_qs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FuncionarioActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private Spinner spinnerTiposRefeicao;
    private Spinner spinnerModalidades;
    private Button buttonLogout;
    private String tipoRefeicaoSelecionado;
    private String modalidadeSelecionada;
    private TextView textViewContadorReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        textViewInfo = findViewById(R.id.textViewInfo);
        spinnerTiposRefeicao = findViewById(R.id.spinnerTiposRefeicao);
        spinnerModalidades = findViewById(R.id.spinnerModalidades);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewContadorReservas = findViewById(R.id.textViewContadorReservas);

        ArrayAdapter<CharSequence> tiposRefeicaoAdapter = ArrayAdapter.createFromResource(
                this, R.array.tipos_refeicao_array, android.R.layout.simple_spinner_item);
        tiposRefeicaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposRefeicao.setAdapter(tiposRefeicaoAdapter);

        ArrayAdapter<CharSequence> modalidadesAdapter = ArrayAdapter.createFromResource(
                this, R.array.modalidades, android.R.layout.simple_spinner_item);
        modalidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModalidades.setAdapter(modalidadesAdapter);

        spinnerTiposRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                tipoRefeicaoSelecionado = parentView.getItemAtPosition(position).toString();
                atualizarInformacoes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spinnerModalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                modalidadeSelecionada = parentView.getItemAtPosition(position).toString();
                atualizarInformacoes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FuncionarioActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        atualizarContadorReservas();
    }

    private void atualizarInformacoes() {
        String informacoes = GestorReservas.obterDetalhesReservasPorTipoEModalidade(tipoRefeicaoSelecionado, modalidadeSelecionada);

        textViewInfo.setText(informacoes);
    }

    private void atualizarContadorReservas() {
        int contador = GestorReservas.getContadorRefeicoesReservadas();
        String textoContador = "Contador de Reservas: " + contador;
        textViewContadorReservas.setText(textoContador);
    }
}
