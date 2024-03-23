package com.example.server.DTO;

import lombok.Data;

@Data
public class AuthenticationResponse {

    public String access_token;
    private String fullName;
    private String email;
}
