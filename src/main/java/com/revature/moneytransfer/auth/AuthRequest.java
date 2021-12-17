package com.revature.moneytransfer.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
