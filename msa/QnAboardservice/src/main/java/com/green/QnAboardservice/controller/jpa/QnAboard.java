package com.green.QnAboardservice.controller.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "qnaboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnAboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String content;

    private String type;

    private LocalDateTime wdate;

    private int views;

    @Enumerated(EnumType.STRING)
    private QnAstate qnastate;

    @Enumerated(EnumType.STRING)
    private QnASecret qnasecret;

//    @Column(nullable = false)
//    private User user;



//    private String comment;
//
//    private String commentuser; //
//

}
