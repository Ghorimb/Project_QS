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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        textViewInfo = findViewById(R.id.textViewInfo);
        spinnerTiposRefeicao = findViewById(R.id.spinnerTiposRefeicao);
        spinnerModalidades = findViewById(R.id.spinnerModalidades);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Configurar adaptadores para os spinners
        ArrayAdapter<CharSequence> tiposRefeicaoAdapter = ArrayAdapter.createFromResource(
                this, R.array.tipos_refeicao_array, android.R.layout.simple_spinner_item);
        tiposRefeicaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposRefeicao.setAdapter(tiposRefeicaoAdapter);

        ArrayAdapter<CharSequence> modalidadesAdapter = ArrayAdapter.createFromResource(
                this, R.array.modalidades, android.R.layout.simple_spinner_item);
        modalidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModalidades.setAdapter(modalidadesAdapter);

        // Configurar um listener para o spinner de tipos de refeição
        spinnerTiposRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Atualizar o tipo de refeição selecionado
                tipoRefeicaoSelecionado = parentView.getItemAtPosition(position).toString();
                // Atualizar as informações com base no tipo de refeição e modalidade selecionados
                atualizarInformacoes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Implemente se necessário
            }
        });

        // Configurar um listener para o spinner de modalidades
        spinnerModalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Atualizar a modalidade selecionada
                modalidadeSelecionada = parentView.getItemAtPosition(position).toString();
                // Atualizar as informações com base no tipo de refeição e modalidade selecionados
                atualizarInformacoes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Implemente se necessário
            }
        });

        // Configurar um listener para o botão de logout
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

    private void atualizarInformacoes() {
        // Obter informações sobre as reservas com base no tipo de refeição e modalidade selecionados
        String informacoes = GestorReservas.obterDetalhesReservasPorTipoEModalidade(tipoRefeicaoSelecionado, modalidadeSelecionada);

        // Atualizar o TextView com as informações
        textViewInfo.setText(informacoes);
    }
}
