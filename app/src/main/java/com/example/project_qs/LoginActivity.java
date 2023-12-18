package com.example.project_qs;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter os valores inseridos pelo usuário
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar as credenciais (substitua isso com sua lógica de autenticação real)
                if (isValidCredentials(username, password)) {
                    // Credenciais válidas, iniciar a MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Fecha a LoginActivity para que o usuário não possa voltar a ela pressionando o botão "Voltar"
                } else {
                    // Credenciais inválidas, exibir uma mensagem de erro
                    Toast.makeText(LoginActivity.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Função para verificar as credenciais (substitua isso com sua lógica de autenticação real)
    private boolean isValidCredentials(String username, String password) {
        // Credenciais válidas: admin1, admin2, admin3, admin4
        return (username.equals("admin1") && password.equals("admin1")) ||
                (username.equals("admin2") && password.equals("admin2")) ||
                (username.equals("admin3") && password.equals("admin3")) ||
                (username.equals("admin4") && password.equals("admin4"));
    }
}
