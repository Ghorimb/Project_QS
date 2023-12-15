package com.example.project_qs;
public class User {

    private String name;
    private String identificationNumber;
    private User user;  // Agora usa a enumeração
    private String username;
    private String password;

    public User(String name, String identificationNumber, User user, String username, String password) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.user = user;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

// Métodos getter e outros conforme necessário
//Teste
}

