package com.example.project_qs;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FuncionarioActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private Spinner spinnerModalidades;
    private String modalidadeSelecionada;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        textViewInfo = findViewById(R.id.textViewInfo);
        spinnerModalidades = findViewById(R.id.spinnerModalidades);

        // Configurar o Spinner com as modalidades disponíveis
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.modalidades,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModalidades.setAdapter(adapter);

        // Lidar com a seleção do Spinner
        spinnerModalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Atualizar a modalidade selecionada
                modalidadeSelecionada = parentView.getItemAtPosition(position).toString();

                // Atualizar as informações com base na modalidade selecionada
                atualizarInformacoes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Fazer algo se nada estiver selecionado (opcional)
            }
        });
    }

    private void atualizarInformacoes() {
        // Obter informações sobre as reservas com base no tipo de refeição e modalidade selecionados
        String tipoRefeicao = "Prato"; // Substitua pela lógica necessária para obter o tipo de refeição desejado
        String informacoes = GestorReservas.obterDetalhesReservasPorTipoEModalidade(tipoRefeicao, modalidadeSelecionada);

        // Atualizar o TextView com as informações
        textViewInfo.setText(informacoes);
    }
}

