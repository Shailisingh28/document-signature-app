package com.shaili.backend.DTO;

import com.shaili.backend.Model.Role;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
