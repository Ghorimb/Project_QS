package com.example.project_qs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

public class ClienteActivity extends AppCompatActivity {

    private Spinner spinnerTiposRefeicao;
    private Spinner spinnerModalidades;

    private Button buttonReservar;
    private Button buttonLogout;
    private TextView textViewMensagem;
    private Utilizador utilizador;
    private ImageView imageViewQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        // Obter informações do utilizador autenticado
        utilizador = Autenticacao.autenticarUtilizadorAtual();

        // Inicializar spinners e outros elementos
        spinnerTiposRefeicao = findViewById(R.id.spinnerTiposRefeicao);
        spinnerModalidades = findViewById(R.id.spinnerModalidades);
        buttonReservar = findViewById(R.id.buttonReservar);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewMensagem = findViewById(R.id.textViewMensagem);

        // Configurar adaptadores para os spinners
        ArrayAdapter<CharSequence> tiposRefeicaoAdapter = ArrayAdapter.createFromResource(
                this, R.array.tipos_refeicao_array, android.R.layout.simple_spinner_item);
        tiposRefeicaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposRefeicao.setAdapter(tiposRefeicaoAdapter);

        // Configurar um listener para o spinner de tipos de refeição
        spinnerTiposRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Atualizar o spinner de modalidades com base no tipo de refeição selecionado
                atualizarSpinnerModalidades(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Implemente se necessário
            }
        });

        // Configurar um listener para o botão de reservar
        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter o tipo e a modalidade selecionados
                String tipoRefeicao = spinnerTiposRefeicao.getSelectedItem().toString();
                String modalidade = spinnerModalidades.getSelectedItem().toString();

                // Supondo que você já tenha uma instância de Refeicao
                Refeicao refeicao = new Refeicao(tipoRefeicao, new ArrayList<>(Arrays.asList(modalidade)));

                // Criar uma nova reserva
                Reserva reserva = new Reserva(utilizador, refeicao);
                GestorReservas.adicionarReserva(reserva);

                // Exemplo de como utilizar os dados da reserva
                String mensagem = "Reserva realizada! Detalhes: \n" +
                        "Utilizador: " + reserva.getUtilizador().getNome() + "\n" +
                        "Data da Reserva: " + reserva.getDataReserva() + "\n" +
                        "Tipo de Refeição: " + reserva.getRefeicao().getTipo() + "\n" +
                        "Modalidades: " + reserva.getRefeicao().getModalidades();

                // Atualizar a TextView com a mensagem
                textViewMensagem.setText(mensagem);
            }
        });

        // Configurar um listener para o botão de logout
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

        imageViewQrCode = findViewById(R.id.imageViewQrCode);

        // Exemplo de chamada para gerar um código QR com dados "Exemplo"
        generateQrCode("Exemplo");
    }

    // Método para atualizar o spinner de modalidades com base no tipo de refeição selecionado
    private void atualizarSpinnerModalidades(int tipoRefeicaoPosition) {
        String[] modalidadesArray;
        switch (tipoRefeicaoPosition) {
            case 0: // Prato peixe
                modalidadesArray = getResources().getStringArray(R.array.modalidades_prato_peixe_array);
                break;
            case 1: // Prato carne
                modalidadesArray = getResources().getStringArray(R.array.modalidades_prato_carne_array);
                break;
            case 2: // Vegetariano
                modalidadesArray = getResources().getStringArray(R.array.modalidades_vegetariano_array);
                break;
            default:
                modalidadesArray = new String[0];
        }

        // Configurar adaptador para o spinner de modalidades
        ArrayAdapter<String> modalidadesAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, modalidadesArray);
        modalidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModalidades.setAdapter(modalidadesAdapter);
    }

    private void generateQrCode(String data) {
        int size = 512;

        // Configurar o bitmap para o código QR
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[size * size];

        // Configurar cor branca para todos os pixels
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = Color.WHITE;
        }

        // Configurar cor preta para os módulos escuros com base nos dados
        byte[] dataBytes = data.getBytes();
        int index = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Modificar a lógica para considerar os dados do código QR
                if (index < dataBytes.length) {
                    int pixelValue = (dataBytes[index] >> 7 - j % 8) & 1;
                    pixels[i * size + j] = (pixelValue == 1) ? Color.BLACK : Color.WHITE;
                    index += (j % 8 == 7) ? 1 : 0;
                }
            }
        }

        bitmap.setPixels(pixels, 0, size, 0, 0, size, size);
        imageViewQrCode.setImageBitmap(bitmap);
    }

}