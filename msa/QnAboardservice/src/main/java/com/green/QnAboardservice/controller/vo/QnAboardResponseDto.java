package com.green.QnAboardservice.controller.vo;


import com.green.QnAboardservice.controller.jpa.QnASecret;
import com.green.QnAboardservice.controller.jpa.QnAstate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnAboardResponseDto {

    private Long idx;
    private String title;
    private String content;
    private String type;
    private QnAstate qnastate;
    private QnASecret qnASecret;

    private String Wdate;
//    private String user;
//    private String comment;
//    private String commentuser;

}
