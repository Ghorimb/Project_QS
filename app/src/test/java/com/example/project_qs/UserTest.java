package com.example.project_qs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCreateUser() {
        User user = new User("John Doe", "123456", UserType.USER, "john", "password");

        // Asserts para verificar se o usuário foi criado corretamente
        assertEquals("John Doe", user.getName());
        assertEquals("123456", user.getIdentificationNumber());
        assertEquals(UserType.USER, user.getUserType());
        assertEquals("john", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    // Adicione mais métodos de teste conforme necessário
}

