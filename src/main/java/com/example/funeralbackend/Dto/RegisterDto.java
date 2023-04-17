package com.example.funeralbackend.Dto;

import com.example.funeralbackend.user.UserType;
import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private UserType role;
}
