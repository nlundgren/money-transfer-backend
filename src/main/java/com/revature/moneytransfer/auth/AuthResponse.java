package com.revature.moneytransfer.auth;

public class AuthResponse {

    private String message;
    private final String jwt;
    private int userId;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }
    public void setUserId(int id) {
        this.userId = id;
    }

}
