package com.example.project_qs;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private Map<String, User> registeredUsers;

    public AuthenticationService() {
        this.registeredUsers = new HashMap<>();
    }

    public void registerUser(String username, String password, String name, String identificationNumber, User user) {
        User newUser = new User(name, identificationNumber, user, username, password);
        registeredUsers.put(username, newUser);
    }

    public User loginUser(String username, String password) {
        User user = registeredUsers.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Outros métodos conforme necessário

}


