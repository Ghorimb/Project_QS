package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    public void testCreateUser() {
        UserManager userManager = new UserManager();

        userManager.createUser("john", "password", "John Doe", "123456", UserType.USER);

        // Asserts para verificar se o usuário foi criado corretamente
        assertNotNull(userManager.loginUser("john", "password"));
    }

    @Test
    public void testCreateEmployeeAccess() {
        UserManager userManager = new UserManager();

        userManager.createUser("jane", "password123", "Jane Doe", "789012", UserType.USER);

        // Concede acesso de funcionário e verifica se foi atualizado corretamente
        userManager.createEmployeeAccess("jane");
        assertEquals(UserType.EMPLOYEE, userManager.loginUser("jane", "password123").getUserType());
    }

    // Adicione mais métodos de teste conforme necessário
}

