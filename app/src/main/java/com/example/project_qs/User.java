package com.example.project_qs;

public class User {

    private String name;
    private String identificationNumber;
    private UserType userType;
    private String username;
    private String password;

    public User(String name, String identificationNumber, UserType userType, String username, String password) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    // Métodos getters e setters

    public String getName() {
        return name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


