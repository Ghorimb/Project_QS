package com.example.project_qs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testCreateUser() {
        userManager.createUser("john", "password", "John Doe", "123456", UserType.USER);
        User user = userManager.getUserByUsername("john");

        assertNotNull(user);
        assertEquals("John Doe", user.getName());
        assertEquals("123456", user.getIdentificationNumber());
        assertEquals(UserType.USER, user.getUserType());
    }

    @Test
    public void testCreateEmployeeAccess() {
        userManager.createUser("jane", "password123", "Jane Doe", "789012", UserType.USER);
        userManager.createEmployeeAccess("jane");

        User user = userManager.getUserByUsername("jane");

        assertNotNull(user);
        assertEquals(UserType.EMPLOYEE, user.getUserType());
    }

    // Adicione mais métodos de teste conforme necessário

}

