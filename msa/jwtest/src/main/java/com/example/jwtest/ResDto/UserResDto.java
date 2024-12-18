package com.example.jwtest.ResDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResDto {

    private Long idx;

    private String username;

    private String password;

    private String email;

    private String role;

    private String wdate;

}
