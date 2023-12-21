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

    // Utilizando a mesma instância de Autenticacao em toda a aplicação
    private static Autenticacao autenticacao = new Autenticacao();

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

                // Verificar as credenciais usando a classe Autenticacao
                Utilizador utilizadorAutenticado = autenticacao.autenticarUtilizador(username, password);

                if (utilizadorAutenticado != null) {
                    // Credenciais válidas, iniciar a MainActivity
                    // Também armazenamos o utilizador autenticado na sessão (SessionManager)
                    SessionManager.setUtilizadorAutenticado(utilizadorAutenticado);

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
}
