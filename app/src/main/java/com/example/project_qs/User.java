package com.example.project_qs;
public class User {

    private String name;
    private String identificationNumber;
    private UserType userType;  // Enum para representar o tipo de usuário
    private String username;
    private String password;

    public User(String name, String identificationNumber, UserType userType, String username, String password) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    // Adicione métodos adicionais conforme necessário

}

