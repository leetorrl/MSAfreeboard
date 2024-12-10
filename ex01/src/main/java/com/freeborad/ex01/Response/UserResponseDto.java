package com.freeborad.ex01.Response;

import com.freeborad.ex01.Entity.FreeBoard;
import com.freeborad.ex01.Entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDto {

    private Long idx;

    private String username;

    private int age;

    private String email;

    private String password;

    private LocalDateTime wdate;

    private String role;

//    private List<FreeBoard> list = new ArrayList<>(); //프리보드와 양방향 맵핑

    public UserResponseDto(User user){


        this.idx = user.getIdx();
        this.username = user.getUsername();
        this.age =user.getAge();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.wdate = user.getWdate();
        this.role = user.getRole();
    }
}
