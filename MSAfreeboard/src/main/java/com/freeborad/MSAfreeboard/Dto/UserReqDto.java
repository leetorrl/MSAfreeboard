package com.freeborad.MSAfreeboard.Dto;

import com.freeborad.MSAfreeboard.Entity.Role;
import lombok.Data;

@Data
public class UserReqDto {

    private Long idx;

    private String userid;

    private String password;

    private String name;

    private String phoneNumber;

    private String email;

    private Role role;

    private boolean accept;



}