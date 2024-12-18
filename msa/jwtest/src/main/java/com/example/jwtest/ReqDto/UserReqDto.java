package com.example.jwtest.ReqDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReqDto {

//    private Long idx;

    private String username;

    private String password;

    private String role;

    private String email;

}
