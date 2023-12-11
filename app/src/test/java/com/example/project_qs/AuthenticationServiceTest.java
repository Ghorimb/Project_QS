package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {

    @Test
    public void testRegisterUser() {
        AuthenticationService authService = new AuthenticationService();

        authService.registerUser("john", "password", "John Doe", "123456", UserType.USER);

        // Asserts para verificar se o usuário foi registrado corretamente
        assertNotNull(authService.loginUser("john", "password"));
    }

    @Test
    public void testLoginUser() {
        AuthenticationService authService = new AuthenticationService();

        authService.registerUser("jane", "password123", "Jane Doe", "789012", UserType.USER);

        // Asserts para verificar se o usuário pode fazer login corretamente
        assertNotNull(authService.loginUser("jane", "password123"));
    }

    // Adicione mais métodos de teste conforme necessário
}

