package com.serverside.behappy.models;

public class UserAuth {

    public UserAuth() {
    }

    public UserAuth(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email, password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
