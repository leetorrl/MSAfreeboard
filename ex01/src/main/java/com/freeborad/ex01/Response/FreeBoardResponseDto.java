package com.freeborad.ex01.Response;

import com.freeborad.ex01.Entity.User;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FreeBoardResponseDto {

    private Long idx;

    private String title;

    private String content;

    private Long user_idx;


    private LocalDateTime reg_date;

    private LocalDateTime mod_date;

    private int view_Count;

    private User user; // User와 양방향 맵핑
}
