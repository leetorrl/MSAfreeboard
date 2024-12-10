package com.freeborad.ex01.Dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserReqDto {

    private Long idx;

    private String username;

    private int age;

    private String email;

    private String password;

    private LocalDateTime wdate;

    private String role;



}
