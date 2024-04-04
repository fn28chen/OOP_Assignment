package com.example.server.DTO;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String password;
    private AddressDTO addressDTO;
    private RoleDTO roleDTO;

}
