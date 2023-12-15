package com.example.project_qs;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void createUser(String username, String password, String name, String identificationNumber, UserType userType) {
        User newUser = new User(name, identificationNumber, userType, username, password);
        users.put(username, newUser);
    }

    public void createEmployeeAccess(String username) {
        User user = users.get(username);
        if (user != null) {
            user.setUser(User.EMPLOYEE);
        }
    }

    // Outros métodos conforme necessário

}


