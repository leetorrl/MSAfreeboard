package com.freeborad.ex01.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "free_board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String content;

    @CreatedDate
    private LocalDateTime reg_date;

    private LocalDateTime mod_date;

    private int view_Count;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private User user; // User와 양방향 맵핑

}
