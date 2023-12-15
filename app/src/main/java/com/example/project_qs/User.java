package com.example.project_qs;
public class User {

    private String name;
    private String identificationNumber;
    private UserType userType;  // Agora usa a enumeração
    private String username;
    private String password;

    public User(String name, String identificationNumber, UserType userType, String username, String password) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    // Métodos getter e outros conforme necessário
}

