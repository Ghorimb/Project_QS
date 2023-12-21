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
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                Utilizador utilizadorAutenticado = autenticacao.autenticarUtilizador(username, password);

                if (utilizadorAutenticado != null) {
                    Intent intent;
                    if (utilizadorAutenticado.getTipo() == TipoUtilizador.CLIENTE) {
                        intent = new Intent(LoginActivity.this, ClienteActivity.class);
                    } else if (utilizadorAutenticado.getTipo() == TipoUtilizador.FUNCIONARIO) {
                        intent = new Intent(LoginActivity.this, FuncionarioActivity.class);
                    } else {
                        return;
                    }

                    SessionManager.setUtilizadorAutenticado(utilizadorAutenticado);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
